package com.livros.literalura.principal;


import com.livros.literalura.model.Author;
import com.livros.literalura.model.DataBook;
import com.livros.literalura.repository.AuthorRepository;
import com.livros.literalura.repository.BookRepository;
import com.livros.literalura.service.ConnectAPI;
import com.livros.literalura.service.ConvertData;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class principal {
		ConnectAPI connectAPI = new ConnectAPI();
		ConvertData convertData = new ConvertData();
	    String URL = "https://gutendex.com/books/?search=";
	    Scanner scanner = new Scanner(System.in);
	    int menuNumber = 0;

	    private BookRepository repository;
	    private AuthorRepository repositoryauthor;

	    public void UserInterface(BookRepository repository, AuthorRepository repositoryauthor) {
	        this.repository = repository;
	        this.repositoryauthor = repositoryauthor;
	    }

	    public void printMenu() {

	        while (menuNumber != 6) {
	            System.out.println("===========================");
	            System.out.println("    LITERALURA 1.0    ");
	            System.out.println("===========================");
	            System.out.println("         MENU              ");
	            System.out.println("1 = BUSCAR LIVROS / TITULO");
	            System.out.println("2 = LISTAR LIVROS REGISTRADO");
	            System.out.println("3 = LISTAR AUTORES REGISTRADOS ");
	            System.out.println("4 = LISTAR AUTORES VIVOS / ANO");
	            System.out.println("5 = LISTAR LIVROS / IDIOMA");
	            System.out.println("6 = SAIR");
	            System.out.println("SELECIONE UMA OPÇÃO");
	            menuNumber = scanner.nextInt();

	            if (menuNumber == 1) {
	                System.out.println("DIGITE O TITULO DO LIVRO");
	                scanner.nextLine();
	                var tituloLivro = scanner.nextLine();
	                
	                SelectLivroFromAPI(tituloLivro);
	            }

	            if (menuNumber == 2) {
	                System.out.println("LIVROS REGISTRADOS");
	                SelectAllLivro();
	            }

	            if (menuNumber == 3) {
	                System.out.println("AUTORES REGISTRADOS");
	                SelectAllAutor();
	            }

	            if (menuNumber == 4) {
	                System.out.println("DIGITE O ANO DE FALECIMENTO:");
	                Integer anoSelected = scanner.nextInt();
	                
	                if (anoSelected <= 0){
	                    System.out.println("ANO INVÁLIDO");
	                }else{
	                    SelectAutorVivos(anoSelected);
	                }
	            }

	            if (menuNumber == 5) {
	                System.out.println("1 = PORTUGUES");
	                System.out.println("2 = INGLES");
	                System.out.println("SELECIONE O IDIOMA:");
	                int idiomaSelected = scanner.nextInt();
	                
	                if (idiomaSelected >= 1 || idiomaSelected <= 2 ) {
	                    SelectIdiomaByName(idiomaSelected);
	                }else{
	                    System.out.println("IDIOMA SELECIONADO INVÁLIDO"); 
	                }   
	            }
	        }
	    }

	    private void InsertLivro(DataBook dataBook) {
	        
	        Optional<Book> verificarLivro = repository.findBytituloEqualsIgnoreCase(dataBook.title().toString());
	       
	        if (verificarLivro.isEmpty()){
	        
	            Book book = new Book(dataBook);
	       
	            try {
	                repository.save(book);
	                System.out.println(dataBook.title().toString()+" inserido com sucesso!");
	                System.out.println("----------------------------------");
	            }catch (Exception e) {
	               System.out.println("ERROOO :" + e.getMessage());
	            }
	        }else{
	            System.out.println("LIVRO JÁ PESQUISADO / CADASTRADO");   
	        }    

	    }

	    private void InsertAutor(Integer autorid, String nome, Integer dtnascimento, Integer dtfalecimento) {
	        Author author = new Author(autorid,nome,dtnascimento,dtfalecimento);

	        try {
	            repositoryauthor.save(author);
	            System.out.println(author.getName()+" inserido com sucesso!");
	            System.out.println("----------------------------------");
	    
	        } catch (Exception e) {
	            System.out.println("ERROOO :" + e.getMessage());
	        }

	    }

	    private void SelectLivroFromAPI(String livrotitulo) {
	        String datajson = consumirAPI.obterDados(URL+livrotitulo.replace(" ","%20").toLowerCase());  
	               
	        var books = convertjson.obterDados(datajson,Data.class);
	       
	        Optional<DataBook> livroSelecionado = books.livros().stream()
	            .findFirst(); 

	        if (livroSelecionado.isPresent()){
	        	DataBook dataBook = livroSelecionado.get();
	            
	            InsertLivro(dataBook);
	            InsertAutor(dataBook.id(),dataBook.autores().get(0).nome().toString(),dataBook.autores().get(0).anonascimento(),dataBook.autores().get(0).anofalecimento());
	        }
	        else{
	          System.out.println("NENHUM LIVRO ENCONTRADO");  
	        }             
	    }

	    private void SelectAllLivro() {

	        try {
	            List<Book> livros = repository.findAll();
	          
	           if (livros.size() > 0){
	            livros.forEach(System.out::println);
	           }else{
	            System.out.println("====== NENHUM LIVRO REGISTRADO =======");
	           }

	        } catch (Exception e) {
	            System.out.println("ERROOO :" + e.getMessage());
	        }

	    }

	    private void SelectAllAutor() {

	        try {
	            List<Author> autores = repositoryauthor.findAll();
	            
	            if (autores.size() > 0){
	             autores.forEach(System.out::println);             
	            }else{
	              System.out.println("====== NENHUM AUTOR REGISTRADO =======");
	            } 
	        } catch (Exception e) {
	            System.out.println("ERROOO :" + e.getMessage());
	        }

	    }

	    private void SelectAutorVivos(Integer anofalecimento) {
	          List<Author> autorData = repositoryauthor.findByanofalecimentoLessThan(anofalecimento);
	  
	        if (!autorData.isEmpty()) {
	             System.out.println(autorData);
	             System.out.println("TOTAL DE AUTORES FALECIDOS: "+autorData.size());
	          } else {
	             System.out.println("====================================");
	             System.out.println("NENHUM AUTOR FALECIDO");
	             System.out.println("====================================");
	         }
	    }

	    private void SelectIdiomaByName(int idiomaSelect) {
	        var idioma = "";

	        if (idiomaSelect == 1)
	            idioma = "br";
	        else
	            idioma = "en";

	        List<Book> livroIdioma = repository.findByidiomaContainingIgnoreCase(idioma);
	  
	       if (!livroIdioma.isEmpty()) {
	            System.out.println(livroIdioma);
	            System.out.println("TOTAL DE LIVROS: "+livroIdioma.size());
	         } else {
	            System.out.println("====================================");
	            System.out.println("NENHUM LIVRO ENCONTRADO NESTE IDIOMA");
	            System.out.println("====================================");
	        }
	    }
}
