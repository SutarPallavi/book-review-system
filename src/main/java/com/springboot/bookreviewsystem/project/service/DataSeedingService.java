package com.springboot.bookreviewsystem.project.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.repo.BookRepository;

@Service
public class DataSeedingService implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing books and seed with new collection
        System.out.println("Clearing existing books collection...");
        bookRepository.deleteAll();
        System.out.println("Seeding database with new book collection...");
        seedBooks();
    }

    private void seedBooks() {
        List<BookDto> initialBooks = Arrays.asList(
            // Classic Literature
            BookDto.builder().name("The Hobbit").authore("J.R.R. Tolkien").genre("Fantasy").build(),
            BookDto.builder().name("The Lord of the Rings").authore("J.R.R. Tolkien").genre("Fantasy").build(),
            BookDto.builder().name("1984").authore("George Orwell").genre("Dystopian").build(),
            BookDto.builder().name("Animal Farm").authore("George Orwell").genre("Allegory").build(),
            BookDto.builder().name("Pride and Prejudice").authore("Jane Austen").genre("Romance").build(),
            BookDto.builder().name("To Kill a Mockingbird").authore("Harper Lee").genre("Classic").build(),
            BookDto.builder().name("The Great Gatsby").authore("F. Scott Fitzgerald").genre("Classic").build(),
            BookDto.builder().name("The Catcher in the Rye").authore("J.D. Salinger").genre("Coming-of-Age").build(),
            BookDto.builder().name("Brave New World").authore("Aldous Huxley").genre("Dystopian").build(),
            BookDto.builder().name("The Chronicles of Narnia").authore("C.S. Lewis").genre("Fantasy").build(),
            BookDto.builder().name("The Little Prince").authore("Antoine de Saint-Exupéry").genre("Philosophical").build(),
            
            // Modern Classics
            BookDto.builder().name("The Alchemist").authore("Paulo Coelho").genre("Philosophical").build(),
            BookDto.builder().name("The Kite Runner").authore("Khaled Hosseini").genre("Contemporary").build(),
            BookDto.builder().name("The Book Thief").authore("Markus Zusak").genre("Historical Fiction").build(),
            BookDto.builder().name("The Handmaid's Tale").authore("Margaret Atwood").genre("Dystopian").build(),
            BookDto.builder().name("The Road").authore("Cormac McCarthy").genre("Post-Apocalyptic").build(),
            BookDto.builder().name("Life of Pi").authore("Yann Martel").genre("Adventure").build(),
            
            // Young Adult & Fantasy
            BookDto.builder().name("Harry Potter and the Sorcerer's Stone").authore("J.K. Rowling").genre("Fantasy").build(),
            BookDto.builder().name("The Hunger Games").authore("Suzanne Collins").genre("Dystopian").build(),
            BookDto.builder().name("The Fault in Our Stars").authore("John Green").genre("Young Adult").build(),
            BookDto.builder().name("A Court of Thorns and Roses").authore("Sarah J. Maas").genre("Fantasy Romance").build(),
            BookDto.builder().name("Fourth Wing").authore("Rebecca Yarros").genre("Fantasy").build(),
            BookDto.builder().name("Iron Flame").authore("Rebecca Yarros").genre("Fantasy").build(),
            
            // Thrillers & Mystery
            BookDto.builder().name("The Da Vinci Code").authore("Dan Brown").genre("Thriller").build(),
            BookDto.builder().name("Gone Girl").authore("Gillian Flynn").genre("Thriller").build(),
            BookDto.builder().name("The Girl on the Train").authore("Paula Hawkins").genre("Thriller").build(),
            BookDto.builder().name("The Silent Patient").authore("Alex Michaelides").genre("Thriller").build(),
            BookDto.builder().name("Big Little Lies").authore("Liane Moriarty").genre("Thriller").build(),
            
            // Contemporary Fiction
            BookDto.builder().name("The Curious Incident of the Dog in the Night-Time").authore("Mark Haddon").genre("Contemporary").build(),
            BookDto.builder().name("The Lovely Bones").authore("Alice Sebold").genre("Contemporary").build(),
            BookDto.builder().name("The Time Traveler's Wife").authore("Audrey Niffenegger").genre("Romance").build(),
            BookDto.builder().name("Water for Elephants").authore("Sara Gruen").genre("Historical Fiction").build(),
            BookDto.builder().name("The Help").authore("Kathryn Stockett").genre("Historical Fiction").build(),
            BookDto.builder().name("The Night Circus").authore("Erin Morgenstern").genre("Fantasy").build(),
            BookDto.builder().name("The Goldfinch").authore("Donna Tartt").genre("Contemporary").build(),
            BookDto.builder().name("All the Light We Cannot See").authore("Anthony Doerr").genre("Historical Fiction").build(),
            BookDto.builder().name("The Martian").authore("Andy Weir").genre("Science Fiction").build(),
            BookDto.builder().name("Ready Player One").authore("Ernest Cline").genre("Science Fiction").build(),
            
            // Romance & Contemporary
            BookDto.builder().name("Verity").authore("Colleen Hoover").genre("Romance").build(),
            BookDto.builder().name("It Ends with Us").authore("Colleen Hoover").genre("Romance").build(),
            BookDto.builder().name("The Seven Husbands of Evelyn Hugo").authore("Taylor Jenkins Reid").genre("Romance").build(),
            BookDto.builder().name("Daisy Jones & The Six").authore("Taylor Jenkins Reid").genre("Romance").build(),
            BookDto.builder().name("Lessons in Chemistry").authore("Bonnie Garmus").genre("Contemporary").build(),
            BookDto.builder().name("Tomorrow, and Tomorrow, and Tomorrow").authore("Gabrielle Zevin").genre("Contemporary").build(),
            
            // Modern Fiction
            BookDto.builder().name("Yellowface").authore("R.F. Kuang").genre("Contemporary").build(),
            BookDto.builder().name("The Midnight Library").authore("Matt Haig").genre("Contemporary").build(),
            BookDto.builder().name("Klara and the Sun").authore("Kazuo Ishiguro").genre("Science Fiction").build(),
            BookDto.builder().name("Project Hail Mary").authore("Andy Weir").genre("Science Fiction").build(),
            BookDto.builder().name("Cloud Cuckoo Land").authore("Anthony Doerr").genre("Historical Fiction").build(),
            BookDto.builder().name("The Lincoln Highway").authore("Amor Towles").genre("Historical Fiction").build(),
            
            // Indian Literature
            BookDto.builder().name("The White Tiger").authore("Aravind Adiga").genre("Contemporary").build(),
            BookDto.builder().name("The God of Small Things").authore("Arundhati Roy").genre("Contemporary").build(),
            BookDto.builder().name("Midnight's Children").authore("Salman Rushdie").genre("Magical Realism").build(),
            BookDto.builder().name("The Namesake").authore("Jhumpa Lahiri").genre("Contemporary").build(),
            BookDto.builder().name("The Palace of Illusions").authore("Chitra Banerjee Divakaruni").genre("Historical Fiction").build(),
            
            // Science Fiction & Dystopian
            BookDto.builder().name("Dune").authore("Frank Herbert").genre("Science Fiction").build(),
            BookDto.builder().name("Neuromancer").authore("William Gibson").genre("Cyberpunk").build(),
            BookDto.builder().name("The Stand").authore("Stephen King").genre("Horror").build(),
            BookDto.builder().name("Station Eleven").authore("Emily St. John Mandel").genre("Post-Apocalyptic").build(),
            BookDto.builder().name("The Power").authore("Naomi Alderman").genre("Science Fiction").build(),
            
            // Historical Fiction
            BookDto.builder().name("The Pillars of the Earth").authore("Ken Follett").genre("Historical Fiction").build(),
            BookDto.builder().name("Wolf Hall").authore("Hilary Mantel").genre("Historical Fiction").build(),
            BookDto.builder().name("The Nightingale").authore("Kristin Hannah").genre("Historical Fiction").build(),
            BookDto.builder().name("The Tattooist of Auschwitz").authore("Heather Morris").genre("Historical Fiction").build()
        );

        // Convert DTOs to entities and save
        for (BookDto bookDto : initialBooks) {
            Book book = new Book();
            book.setName(bookDto.getName());
            book.setAuthore(bookDto.getAuthore());
            book.setGenre(bookDto.getGenre());
            bookRepository.save(book);
        }

        System.out.println("Database seeded with " + initialBooks.size() + " books");
    }
}
