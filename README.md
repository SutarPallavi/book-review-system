# 📚 Ctrl+Book - Book Review System

A comprehensive Spring Boot-based book review platform where users can discover, rate, and review books. Built with modern web technologies and MongoDB for scalable data storage.

## 🌟 Features

### ✨ Core Functionality
- **User Registration & Authentication** - Secure user management with password hashing
- **Book Discovery** - Browse through 64+ curated books across various genres
- **Review System** - Submit and view book reviews with star ratings (1-5 stars)
- **Genre Filtering** - Filter books by genre (Fiction, Non-Fiction, Science Fiction, etc.)
- **Contact Form** - Customer inquiry system with MongoDB storage
- **Responsive Design** - Modern, mobile-friendly UI built with HTML5, CSS3, and JavaScript

### 🎨 User Interface
- **Hero Section** - Beautiful book stack visualization with SVG graphics
- **Interactive Elements** - Modal dialogs, form validation, and smooth animations
- **Genre Tags** - Visual genre indicators for easy book categorization
- **Star Ratings** - Interactive star rating system for book reviews

## 🛠️ Tech Stack

### Backend
- **Java 8** - Core programming language
- **Spring Boot 2.7.x** - Application framework
- **Spring Data MongoDB** - Database integration
- **Spring Security Crypto** - Password hashing (BCrypt)
- **Maven** - Build automation and dependency management

### Database
- **MongoDB 6.0+** - NoSQL document database
- **Local MongoDB** - Running on `127.0.0.1:27017`
- **Collections**: `Books`, `Users`, `UserReviews`, `CustomerMails`

### Frontend
- **HTML5** - Semantic markup
- **CSS3** - Modern styling with Flexbox and Grid
- **JavaScript (ES6+)** - Client-side interactivity
- **SVG Graphics** - Custom book illustrations and icons
- **Responsive Design** - Mobile-first approach

### Development Tools
- **Spring Boot DevTools** - Hot reload and development utilities
- **MongoDB Compass** - Database management interface
- **LiveReload** - Automatic browser refresh during development

## 🚀 Getting Started

### Prerequisites
- **Java 8** (JDK 1.8.0_202 or higher)
- **MongoDB 6.0+** installed and running
- **Maven 3.6+** or use included Maven wrapper
- **Git** for version control

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/SutarPallavi/book-review-system.git
   cd book-review-system
   ```

2. **Set Environment Variables**
   ```bash
   # Windows PowerShell
   $env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_202"
   $env:SPRING_DATA_MONGODB_URI = "mongodb://127.0.0.1:27017"
   $env:SPRING_DATA_MONGODB_DATABASE = "Books"
   $env:SERVER_PORT = "8081"
   ```

3. **Start MongoDB**
   ```bash
   # Start MongoDB service
   net start MongoDB
   
   # Or start MongoDB directly
   "C:\Program Files\MongoDB\Server\6.0\bin\mongod.exe"
   ```

4. **Run the Application**
   ```bash
   # Using Maven wrapper
   .\mvnw.cmd spring-boot:run
   
   # Or using Maven directly
   mvn spring-boot:run
   ```

5. **Access the Application**
   - **Main Page**: http://localhost:8081/
   - **Books Page**: http://localhost:8081/books.html
   - **Contact Page**: http://localhost:8081/contact.html
   - **Registration**: http://localhost:8081/register.html

## 📁 Project Structure

```
BookReviewSystem/
├── src/
│   ├── main/
│   │   ├── java/com/springboot/bookreviewsystem/project/
│   │   │   ├── controller/          # REST API controllers
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── entity/              # MongoDB entities
│   │   │   ├── enums/               # Enumerations
│   │   │   ├── repo/                # MongoDB repositories
│   │   │   ├── service/             # Business logic services
│   │   │   └── utils/               # Utility classes
│   │   └── resources/
│   │       ├── static/              # Frontend assets
│   │       │   ├── css/             # Stylesheets
│   │       │   ├── js/              # JavaScript files
│   │       │   └── *.html           # HTML pages
│   │       └── application.yml      # Spring Boot configuration
│   └── test/                        # Test files
├── pom.xml                          # Maven dependencies
└── README.md                        # This file
```

## 🔌 API Endpoints

### Book Management
- `GET /books/getAllBooks` - Retrieve all books
- `GET /books/getBooksAndReviews` - Get books with reviews
- `GET /books/getBooksByGenre?genre={genre}` - Filter books by genre
- `POST /books/savebook` - Save a new book

### User Management
- `POST /userprofiles/saveuserprofile` - Register new user
- `GET /userprofiles/getalluserprofiles` - Get all user profiles
- `GET /userprofiles/getuserprofile/{id}` - Get user by ID

### Review System
- `POST /users/userreviews` - Submit book review
- `GET /users/userreviews` - Get all reviews

### Contact Form
- `POST /contact/submit` - Submit contact form
- `GET /contact/mails` - Get all contact submissions
- `GET /contact/mails/{id}` - Get specific contact submission
- `PUT /contact/mails/{id}/status` - Update submission status

### Web Pages
- `GET /` - Home page (index.html)
- `GET /register` - Registration page
- `GET /books.html` - Books listing page
- `GET /contact.html` - Contact form page

## 🗄️ Database Schema

### Books Collection
```json
{
  "_id": "Integer",
  "title": "String",
  "author": "String",
  "genre": "String",
  "description": "String",
  "publishedYear": "Integer"
}
```

### Users Collection
```json
{
  "_id": "Long",
  "userName": "String",
  "emailId": "String",
  "passwordHash": "String (BCrypt)",
  "favoriteBookGenres": ["BookGenres"],
  "phoneNumber": "String",
  "dateOfBirth": "Date"
}
```

### UserReviews Collection
```json
{
  "_id": "String",
  "bookId": "Integer",
  "userName": "String",
  "rating": "Integer (1-5)",
  "review": "String",
  "reviewDate": "Date"
}
```

### CustomerMails Collection
```json
{
  "_id": "String",
  "name": "String",
  "email": "String",
  "subject": "String",
  "message": "String",
  "submittedAt": "DateTime",
  "status": "String (new/read/replied)"
}
```

## 🎯 Key Features Explained

### Book Stack Visualization
The homepage features a custom SVG illustration showing three stacked books in different colors (teal, red, blue), representing the variety of books available for review.

### Genre-Based Filtering
Users can filter books by genre using the dropdown menu on the books page. The system supports multiple genres including:
- Fiction
- Non-Fiction
- Science Fiction
- Mystery/Thriller
- Romance
- Fantasy
- Biography
- History
- And more...

### Review System
- **Rating**: 1-5 star rating system
- **Review Text**: Detailed text reviews
- **User Attribution**: Reviews are linked to usernames
- **Real-time Updates**: Reviews appear immediately after submission

### Data Seeding
The application automatically seeds the database with 64+ books on startup, ensuring users always have content to explore and review.

## 🔧 Configuration

### Application Properties (`application.yml`)
```yaml
server:
  port: 8081

spring:
  data:
    mongodb:
      uri: mongodb://127.0.0.1:27017
      database: Books
```

### Maven Dependencies (`pom.xml`)
Key dependencies include:
- `spring-boot-starter-web` - Web application framework
- `spring-boot-starter-data-mongodb` - MongoDB integration
- `spring-security-crypto` - Password hashing
- `mongodb-driver-dns` - MongoDB DNS resolution

## 🚀 Deployment

### Local Development
1. Ensure MongoDB is running on port 27017
2. Set JAVA_HOME environment variable
3. Run `mvn spring-boot:run`
4. Access application at http://localhost:8081

### Production Considerations
- Configure MongoDB connection for production environment
- Set appropriate security measures
- Configure logging levels
- Set up monitoring and health checks

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Team

- **Developer**: Pallavi Sutar
- **Project**: Book Review System
- **Repository**: https://github.com/SutarPallavi/book-review-system

## 🆘 Support

For support and questions:
- **Email**: ctrlbookbookreviewsystems@gmail.com
- **Contact Form**: Use the contact form on the website
- **Issues**: Report bugs and feature requests via GitHub Issues

## 🔄 Recent Updates

### Latest Features (v2.0)
- ✅ Enhanced book stack visualization on homepage
- ✅ Contact form with MongoDB storage
- ✅ Genre-based book filtering
- ✅ Removed price fields for cleaner interface
- ✅ Enhanced data seeding with 64+ books
- ✅ Improved responsive design
- ✅ Better error handling and validation

### Upcoming Features
- 🔄 User profile management
- 🔄 Advanced search functionality
- 🔄 Book recommendations
- 🔄 Social sharing features
- 🔄 Admin dashboard

---

**Happy Reading and Reviewing! 📖⭐**
