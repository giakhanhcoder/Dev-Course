INSERT INTO Category (category_name, description) VALUES
('Technology', 'Courses related to technology and programming'),
('Business', 'Courses related to business and entrepreneurship'),
('Art', 'Courses related to art and design'),
('Language', 'Courses related to language learning');

-- Dữ liệu cho các khóa học liên quan đến Công nghệ
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, course_feedback, user_id) VALUES
('course1', 'Learn Web Development', 'Web Development 101', '2024-05-01 00:00:00', 'web_dev.jpg', 1, 1, 'Introduction to Web Development', 100, 4, 'Great course!', 'user3'),
('course2', 'Master Machine Learning', 'Machine Learning Mastery', '2024-05-01 00:00:00', 'ml.jpg', 1, 1, 'Advanced Machine Learning Techniques', 150, 5, 'Best course ever!', 'user4');

-- Dữ liệu cho các khóa học liên quan đến Kinh doanh
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, course_feedback, user_id) VALUES
('course3', 'Entrepreneurship Basics', 'Start Your Own Business', '2024-05-01 00:00:00', 'business.jpg', 1, 2, 'Foundations of Entrepreneurship', 120, 4, 'Very informative!', 'user5'),
('course4', 'Financial Management', 'Mastering Finance', '2024-05-01 00:00:00', 'finance.jpg', 1, 2, 'Advanced Financial Strategies', 180, 5, 'Excellent content!', 'user6');

-- Dữ liệu cho các khóa học liên quan đến Nghệ thuật
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, course_feedback, user_id) VALUES
('course5', 'Introduction to Drawing', 'Drawing Fundamentals', '2024-05-01 00:00:00', 'drawing.jpg', 1, 3, 'Basic Drawing Techniques', 90, 4, 'Really helpful!', 'user7'),
('course6', 'Digital Painting Mastery', 'Advanced Digital Art', '2024-05-01 00:00:00', 'digital_art.jpg', 1, 3, 'Mastering Digital Painting', 150, 5, 'Amazing course!', 'user8');

-- Dữ liệu cho các khóa học liên quan đến Ngôn ngữ
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, course_feedback, user_id) VALUES
('course7', 'Learn Spanish from scratch', 'Spanish for Beginners', '2024-05-01 00:00:00', 'spanish.jpg', 1, 4, 'Basic Spanish Course', 80, 4, 'Very helpful for beginners!', 'user9'),
('course8', 'Advanced French Conversation', 'French Mastery', '2024-05-01 00:00:00', 'french.jpg', 1, 4, 'Advanced French Speaking Skills', 120, 5, 'Great course for advanced learners!', 'user10');
