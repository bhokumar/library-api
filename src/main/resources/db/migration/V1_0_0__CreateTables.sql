CREATE TABLE IF NOT EXISTS `Author` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `birthdate` DATE
);

CREATE TABLE IF NOT EXISTS `Book` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(100) NOT NULL,
    `author_id` INT NOT NULL,
    `published_date` DATE,
    `isbn` VARCHAR(20) UNIQUE,
    `genre` VARCHAR(50),
    `available` BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (`author_id`) REFERENCES `Author`(`id`)
);

CREATE TABLE IF NOT EXISTS `Member` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) UNIQUE,
    `membership_date` DATE
);

CREATE TABLE IF NOT EXISTS `Loan` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `book_id` INT NOT NULL,
    `member_id` INT NOT NULL,
    `loan_date` DATE NOT NULL,
    `due_date` DATE NOT NULL,
    `return_date` DATE,
    FOREIGN KEY (`book_id`) REFERENCES `Book`(`id`),
    FOREIGN KEY (`member_id`) REFERENCES `Member`(`id`)
);