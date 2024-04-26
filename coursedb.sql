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
    course_name VARCHAR(255) NOT NULL UNIQUE,
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

-- Tạo bảng Lesson
CREATE TABLE Lesson (
    lesson_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content_link TEXT NOT NULL,
    course_id VARCHAR(255),
    lesson_title VARCHAR(255) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

-- Tạo bảng Assignment_Score
CREATE TABLE ASSIGNMENT_SCORE(
	 user_id VARCHAR(255),
     lesson_id BIGINT,
     score float,
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
CREATE TABLE Total_Expenses (
    total_expenses_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_expenses BIGINT,
    user_id VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Tạo bảng Order
CREATE TABLE Orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255),
    user_id VARCHAR(255) NOT NULL,  -- Sửa kiểu dữ liệu thành VARCHAR(255)
    course_id VARCHAR(255),
    payment_at DATETIME(6),
    total_expenses_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (total_expenses_id) REFERENCES Total_Expenses(total_expenses_id)
);

-- Tạo bảng trung gian để lưu thông tin về các đơn hàng và khóa học được mua
CREATE TABLE Order_Course (
    order_id BIGINT,
    course_id VARCHAR(255),
    PRIMARY KEY (order_id, course_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);



-- Tạo bảng Comment
CREATE TABLE Comment (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment_body VARCHAR(255),
    lesson_id BIGINT,
    FOREIGN KEY (lesson_id) REFERENCES Lesson(lesson_id)
);
-- Tạo bảng Refesh_token
CREATE TABLE Refresh_token (
    user_id VARCHAR(255),
    expiry_date DATETIME(6),
    token VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)  
);


INSERT INTO Role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO Role (role_name) VALUES ('ROLE_MENTOR');
INSERT INTO Role (role_name) VALUES ('ROLE_STUDENT');



