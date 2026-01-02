<div align="center">
  <h1>Telegram Birthday Bot</h1>
  <p>An Automated Bot to Wish Birthdays on Telegram</p>
  <p><strong>Java | Spring Boot | Telegram Bot API | JSON Database</strong></p>
  <br>
</div>

## About

Telegram Birthday Bot is a fully functional Java application that automatically sends birthday wishes to users on Telegram. It manages subscriber information, tracks birthdays, and sends personalized birthday messages at the right time.

## Features

- Automated birthday wish sending
- Subscriber management system
- JSON-based data storage
- Telegram Bot API integration
- Subscribe/Unsubscribe functionality
- Flexible scheduling for birthday messages
- Production-ready deployment
- Easy configuration and setup

## Tech Stack

| Component | Technology |
|-----------|------------|
| Core Language | Java |
| Framework | Spring Boot |
| Telegram Integration | Telegram Bot API |
| Data Storage | JSON (subscribers.json) |
| Build Tool | Maven |
| Containerization | Docker |
| Deployment | Telegram Cloud |

## Project Structure

telegram_birthday_bot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/      # Telegram command handlers
│   │   │   ├── service/        # Business logic
│   │   │   └── model/          # Data models
│   │   └── resources/      # Configuration files
│   └── test/               # Unit tests
├── subscribers.json        # Subscriber data
├── pom.xml                 # Maven configuration
├── Dockerfile              # Docker configuration
└── mvnw/mvnw.cmd          # Maven wrapper

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Telegram Bot Token (from @BotFather)
- Git

### Installation

1. Clone the repository
git clone https://github.com/nikhilajjarapu6/telegram_birthday_bot.git
cd telegram_birthday_bot

2. Get your Telegram Bot Token
- Chat with @BotFather on Telegram
- Create a new bot and get the API token

3. Configure application
Update configuration files with your bot token:
src/main/resources/application.properties

4. Build the project
mvn clean install

5. Run the application
mvn spring-boot:run

Or using Maven wrapper:
./mvnw spring-boot:run

## How to Use

### For Users

1. Start the bot on Telegram
2. Send /start command
3. Send /subscribe to register your birthday
4. Provide your birthday date when prompted
5. Receive birthday wishes on your special day!

### Bot Commands

- `/start` - Initialize the bot
- `/subscribe` - Register your birthday
- `/unsubscribe` - Remove from birthday list
- `/help` - View available commands
- `/mybirthday` - Check your registered birthday

## How It Works

1. **Subscriber Registration**: Users register their birthdays via Telegram commands
2. **Data Storage**: Birthday information is stored in subscribers.json
3. **Scheduled Checks**: The bot periodically checks for upcoming birthdays
4. **Automatic Messages**: Sends wishes to users on their birthday
5. **Persistence**: All data is saved locally and survives restarts

## Deployment

The project is successfully deployed on Telegram infrastructure with:
- 37 total deployments
- 2 production deployments (perfect-warmth, enchanting-perfection)
- Containerized using Docker
- Production-ready configuration

## Project Statistics

- Language: Java 95.3%
- Containerization: Dockerfile 4.7%
- Build Tool: Maven
- Active Development: Yes

## Recent Updates

- Updated methods in subscribersService.java for improved functionality
- Enhanced subscriber management
- Optimized birthday notification system

## Learning Outcomes

Building this bot provided experience with:
- Telegram Bot API integration
- Spring Boot application development
- JSON data persistence
- Scheduled task execution
- Cloud deployment strategies
- Production-level Java applications

## Contributing

We welcome contributions! Here's how to help:

1. Fork the repository
2. Create a feature branch (git checkout -b feature/improvement)
3. Commit your changes (git commit -m 'Add improvement')
4. Push to the branch (git push origin feature/improvement)
5. Open a Pull Request

## Author

Nikhil Ajjarapu (@nikhilajjarapu6)
- Java Developer | Telegram Bot Enthusiast
- Building automation solutions with Java

## Support & Questions

For support:
- Open an Issue on GitHub
- Check the source code documentation
- Review Spring Boot documentation

---

Made with passion for automation

If this bot helps you, please give it a star!
