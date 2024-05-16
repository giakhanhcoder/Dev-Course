 -- create database devcourse;

-- Tạo bảng Category
CREATE TABLE Category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

-- Tạo bảng Role
CREATE TABLE Role (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name ENUM('ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_STUDENT')
);

-- Tạo bảng User
CREATE TABLE Users (
    user_id VARCHAR(255) PRIMARY KEY,
    address VARCHAR(255),
    birthday DATETIME(6),
    create_at DATETIME(6),
	update_at DATETIME(6),
    email VARCHAR(255) NOT NULL UNIQUE,
    is_active BIT,
    first_name VARCHAR(255) NOT NULL,
    gender BIT,
    avatar_url VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    phone_number VARCHAR(255),
    budget BIGINT
);

-- Tạo bảng Student
CREATE TABLE Student (
    user_id VARCHAR(255),
    performance VARCHAR(255),
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)  -- Thêm ràng buộc khóa ngoại
);

-- Tạo bảng Mentor
CREATE TABLE Mentor (
    user_id VARCHAR(255),
    degree VARCHAR(255) NOT NULL,
    experience INT NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)  -- Thêm ràng buộc khóa ngoại
);



-- Tạo bảng Course
CREATE TABLE Course (
    course_id VARCHAR(255) PRIMARY KEY,
    course_des TEXT,
    course_name VARCHAR(255) NOT NULL,
    duration int NOT NULL,
    image_course_url VARCHAR(255),
    is_active BIT,
    category_id BIGINT,
    course_title TEXT,
    course_price BIGINT,
    course_rate INT,
    user_id VARCHAR(255), 
    FOREIGN KEY (category_id) REFERENCES Category(category_id),
    FOREIGN KEY (user_id) REFERENCES Mentor(user_id)  -- Thêm khóa ngoại đến Mentor
);

CREATE TABLE Section(
	 section_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     section_name VARCHAR(255),
	course_id VARCHAR(255),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

-- Tạo bảng Lesson
CREATE TABLE Lesson (
    lesson_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content_link TEXT NOT NULL,
    section_id BIGINT,
    lesson_title VARCHAR(255) NOT NULL,
    FOREIGN KEY (section_id) REFERENCES Section(section_id)
);

-- Tạo bảng Assignment_Score
CREATE TABLE ASSIGNMENT_SCORE(
	 user_id VARCHAR(255),
     lesson_id BIGINT,
     score double,
	 PRIMARY KEY (user_id, lesson_id),
	 FOREIGN KEY (user_id) REFERENCES Student(user_id),
	 FOREIGN KEY (lesson_id) REFERENCES Lesson(lesson_id)
);

-- Tạo bảng Question
CREATE TABLE Question (
    question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    answer ENUM('OPTION_A', 'OPTION_B', 'OPTION_C', 'OPTION_D'),
    question_text VARCHAR(255) NOT NULL,
    lesson_id BIGINT,
    option_a VARCHAR(255),
    option_b VARCHAR(255),
    option_c VARCHAR(255),
    option_d VARCHAR(255),
    FOREIGN KEY (lesson_id) REFERENCES Lesson(lesson_id)
);

-- Tạo bảng Student_course
CREATE TABLE Student_course (
	course_score INT, -- điểm khóa học dựa trên đánh giá của học sinh
	course_feedback VARCHAR(255),
    register_date DATETIME(6),
    course_id VARCHAR(255),
    user_id VARCHAR(255),
	PRIMARY KEY (user_id, course_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id),
    FOREIGN KEY (user_id) REFERENCES Student(user_id)
);

-- Tạo bảng Student_answer
CREATE TABLE Student_answer (
    question_id BIGINT,
    user_id VARCHAR(255),
    student_answer ENUM('OPTION_A', 'OPTION_B', 'OPTION_C', 'OPTION_D'),
    PRIMARY KEY (question_id, user_id),
    FOREIGN KEY (question_id) REFERENCES Question(question_id),
    FOREIGN KEY (user_id) REFERENCES Student(user_id)
);

-- Tạo bảng User_role
CREATE TABLE User_role (
    user_id VARCHAR(255),
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);


-- Tạo bảng Total_Expenses
CREATE TABLE Orders (
    order_id VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255),
	full_name varchar(255),
	email varchar(255) NOT NULL,
	phone_number VARCHAR(255) NOT NULL,
	note VARCHAR(255),
	 order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    tracking_number varchar(255),
--    status ENUM('pending', 'processing', 'delivered', 'cancelled'),
    status VARCHAR(255),
	total_money BIGINT,
    shipping_method VARCHAR(255),
    shipping_address VARCHAR(255),   
    shipping_date DATE,
    payment_method VARCHAR(255),   
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Tạo bảng Order
CREATE TABLE Order_Detail (
    order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	course_price BIGINT,
    order_id VARCHAR(255),
	course_id VARCHAR(255),
	FOREIGN KEY (course_id) REFERENCES Course(course_id),
	FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

-- Tạo bảng Comment
CREATE TABLE Comment (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment_body VARCHAR(255),
    lesson_id BIGINT,
	FOREIGN KEY (lesson_id) REFERENCES Lesson(lesson_id),
    user_id VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Tạo bảng Token
CREATE TABLE Token (
    token_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(255) NOT NULL UNIQUE,
    expiration_date DATETIME(6),
    expired bit,
    revoked bit,
     refresh_token VARCHAR(255) NOT NULL UNIQUE,
    refresh_expiration_date DATETIME(6),
     token_type varchar(255),
    user_id varchar(255),
    is_mobile TINYINT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)  
);


INSERT INTO Role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO Role (role_name) VALUES ('ROLE_MENTOR');
INSERT INTO Role (role_name) VALUES ('ROLE_STUDENT');



