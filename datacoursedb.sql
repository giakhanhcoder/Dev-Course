INSERT INTO Category (category_name, description) VALUES
('Technology', 'Courses related to technology and programming'),
('Business', 'Courses related to business and entrepreneurship'),
('Art', 'Courses related to art and design'),
('Language', 'Courses related to language learning');

insert into mentor(user_id, degree, experience)
values('33b190cd-a853-41a6-9c31-667838f9ccb4', 'bachelor', 3);

-- Dữ liệu cho các khóa học liên quan đến Công nghệ
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, user_id) VALUES
('course1', 'Learn Web Development', 'Web Development 101', 30, 'web_dev.jpg', 1, 1, 'Introduction to Web Development', 100, 4, '33b190cd-a853-41a6-9c31-667838f9ccb4'),
('course2', 'Master Machine Learning', 'Machine Learning Mastery', 20, 'ml.jpg', 1, 1, 'Advanced Machine Learning Techniques', 150, 5, '33b190cd-a853-41a6-9c31-667838f9ccb4');

-- Dữ liệu cho các khóa học liên quan đến Kinh doanh
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, user_id) VALUES
('course3', 'Entrepreneurship Basics', 'Start Your Own Business', 10, 'business.jpg', 1, 2, 'Foundations of Entrepreneurship', 120, 4, '33b190cd-a853-41a6-9c31-667838f9ccb4'),
('course4', 'Financial Management', 'Mastering Finance', 15, 'finance.jpg', 1, 2, 'Advanced Financial Strategies', 180, 5, '33b190cd-a853-41a6-9c31-667838f9ccb4');

-- Dữ liệu cho các khóa học liên quan đến Nghệ thuật
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, user_id) VALUES
('course5', 'Introduction to Drawing', 'Drawing Fundamentals', 22, 'drawing.jpg', 1, 3, 'Basic Drawing Techniques', 90, 4, '33b190cd-a853-41a6-9c31-667838f9ccb4'),
('course6', 'Digital Painting Mastery', 'Advanced Digital Art', 24, 'digital_art.jpg', 1, 3, 'Mastering Digital Painting', 150, 5, '33b190cd-a853-41a6-9c31-667838f9ccb4');

-- Dữ liệu cho các khóa học liên quan đến Ngôn ngữ
INSERT INTO Course (course_id, course_des, course_name, duration, image_course_url, is_active, category_id, course_title, course_price, course_rate, user_id) VALUES
('course7', 'Learn Spanish from scratch', 'Spanish for Beginners', 33, 'spanish.jpg', 1, 4, 'Basic Spanish Course', 80, 4, '33b190cd-a853-41a6-9c31-667838f9ccb4'),
('course8', 'Advanced French Conversation', 'French Mastery', 27, 'french.jpg', 1, 4, 'Advanced French Speaking Skills', 120, 5, '33b190cd-a853-41a6-9c31-667838f9ccb4');

INSERT INTO Section(section_name, course_id) VALUES
('section 1', 'course1'),
('section 2', 'course1'),
('section 3', 'course1'),
('section 1', 'course2'),
('section 2', 'course2'),
('section 3', 'course2'),
('section 1', 'course3'),
('section 2', 'course3'),
('section 3', 'course3'),
('section 1', 'course4'),
('section 2', 'course4'),
('section 3', 'course4'),
('section 1', 'course5'),
('section 2', 'course5'),
('section 3', 'course5'),
('section 1', 'course6'),
('section 2', 'course6'),
('section 3', 'course6');
-- Tạo dữ liệu cho bảng Lesson dựa trên dữ liệu có sẵn trong bảng Course

-- Bài học cho khóa học "Web Development 101"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('web_dev_lesson1_link', 1, 'Introduction to HTML'),
('web_dev_lesson2_link', 2, 'CSS Basics'),
('web_dev_lesson3_link', 3, 'JavaScript Fundamentals'),
('web_dev_lesson4_link', 3, 'Responsive Design Principles');

-- Bài học cho khóa học "Machine Learning Mastery"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('ml_lesson1_link', 4, 'Introduction to Machine Learning'),
('ml_lesson2_link', 5, 'Regression Techniques'),
('ml_lesson3_link', 6, 'Classification Algorithms'),
('ml_lesson4_link', 5, 'Clustering Methods');

-- Bài học cho khóa học "Start Your Own Business"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('business_lesson1_link', 7, 'Introduction to Entrepreneurship'),
('business_lesson2_link', 7, 'Market Research Strategies'),
('business_lesson3_link', 8, 'Business Plan Development'),
('business_lesson4_link', 9, 'Marketing and Sales Tactics');

-- Bài học cho khóa học "Advanced Digital Art"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('digital_art_lesson1_link', 10, 'Introduction to Digital Art'),
('digital_art_lesson2_link', 11, 'Digital Painting Techniques'),
('digital_art_lesson3_link', 12, 'Color Theory for Artists'),
('digital_art_lesson4_link', 12, 'Creating Realistic Digital Portraits');

-- Bài học cho khóa học "Basic Spanish Course"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('spanish_lesson1_link', 13, 'Greetings and Introductions'),
('spanish_lesson2_link', 13, 'Basic Vocabulary and Phrases'),
('spanish_lesson3_link', 14, 'Grammar Essentials'),
('spanish_lesson4_link', 15, 'Conversational Practice');

-- Bài học cho khóa học "Advanced French Speaking Skills"
INSERT INTO Lesson (content_link, section_id, lesson_title) VALUES
('french_lesson1_link', 16, 'Advanced French Pronunciation'),
('french_lesson2_link', 17, 'Idiomatic Expressions and Slang'),
('french_lesson3_link', 18, 'French Literature and Culture'),
('french_lesson4_link', 18, 'Debating and Argumentation in French');

-- Tạo dữ liệu cho bảng Question dựa trên các bài học có sẵn trong bảng Lesson

-- Các câu hỏi cho bài học "Introduction to HTML"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_B', 'What does HTML stand for?', 1, 'Hyperlinks and Text Markup Language', 'Hyper Text Markup Language', 'Home Tool Markup Language', 'Hyperlinks and Textual Markup Language'),
('OPTION_A', 'Which HTML tag is used to define an internal style sheet?', 1, '<style>', '<script>', '<link>', '<head>'),
('OPTION_C', 'What does the "href" attribute do in an anchor tag?', 1, 'Defines the source of the image', 'Defines the heading of the page', 'Defines the hyperlink reference', 'Defines the alternative text for an image');

-- Các câu hỏi cho bài học "CSS Basics"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_D', 'Which CSS property is used to change the text color of an element?', 2, 'text-color', 'font-color', 'color-text', 'color'),
('OPTION_C', 'What is the default value of the "position" property in CSS?', 2, 'static', 'relative', 'absolute', 'fixed'),
('OPTION_B', 'Which CSS selector targets an element based on its class attribute?', 2, 'element selector', 'class selector', 'ID selector', 'attribute selector');

-- Các câu hỏi cho bài học "JavaScript Fundamentals"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_A', 'What is JavaScript?', 3, 'A programming language', 'A database system', 'A web browser', 'A server-side framework'),
('OPTION_D', 'Which JavaScript keyword is used to declare a variable?', 3, 'var', 'let', 'const', 'All of the above'),
('OPTION_C', 'What is the output of the following code? console.log(10 + "20")', 3, '30', '1020', '1020 (string concatenation)', 'Error');

-- Các câu hỏi cho bài học "Introduction to Machine Learning"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_B', 'What is the primary goal of machine learning?', 4, 'To write programs that can think like humans', 'To develop algorithms that can learn from and make predictions on data', 'To build robots with artificial intelligence', 'To create self-aware machines'),
('OPTION_C', 'Which type of machine learning algorithm is used for making predictions based on labeled data?', 4, 'Unsupervised learning', 'Reinforcement learning', 'Supervised learning', 'Semi-supervised learning'),
('OPTION_A', 'What is the term for the process of training a machine learning model on a dataset?', 4, 'Model training', 'Data labeling', 'Feature extraction', 'Data preprocessing');

-- Các câu hỏi cho bài học "Regression Techniques"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_D', 'Which type of regression is best suited for predicting a continuous variable based on other variables?', 5, 'Logistic regression', 'Polynomial regression', 'Ridge regression', 'Linear regression'),
('OPTION_C', 'What is the objective of linear regression?', 5, 'To classify data into multiple classes', 'To cluster data points into groups', 'To model the relationship between independent and dependent variables', 'To identify outliers in the data'),
('OPTION_B', 'What is the output of the regression equation in polynomial regression?', 5, 'A straight line', 'A curve', 'A plane', 'A hyperplane');

-- Các câu hỏi cho bài học "Classification Algorithms"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_A', 'What is the goal of classification?', 6, 'To predict the category or class of an observation based on input variables', 'To estimate a continuous variable based on input variables', 'To cluster similar data points together', 'To identify outliers in the data'),
('OPTION_D', 'Which algorithm is a popular choice for binary classification problems?', 6, 'K-means', 'Decision tree', 'Random forest', 'Logistic regression'),
('OPTION_C', 'What is the decision boundary in a classification algorithm?', 6, 'The line connecting two class centroids', 'The boundary that separates classes in the feature space', 'The threshold used to classify observations', 'The distance between data points in different classes');

-- Các câu hỏi cho bài học "Introduction to Entrepreneurship"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_B', 'What is entrepreneurship?', 7, 'The process of working for someone else', 'The process of starting and running a business', 'The process of investing in stocks', 'The process of studying economics'),
('OPTION_C', 'What is the first step in starting a business?', 7, 'Developing a marketing plan', 'Hiring employees', 'Creating a business plan', 'Choosing a business name'),
('OPTION_D', 'What is a target market?', 7, 'A market where customers can shoot arrows', 'A group of potential customers for a product or service', 'A market where competitors are targeted', 'A market where marketing efforts are concentrated');

-- Các câu hỏi cho bài học "Market Research Strategies"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_B', 'What is market research?', 8, 'The process of selling products at a market', 'The process of gathering information about potential customers and competitors', 'The process of developing new markets', 'The process of advertising products'),
('OPTION_A', 'What are the two main types of market research?', 8, 'Primary research and secondary research', 'Quantitative research and qualitative research', 'Exploratory research and descriptive research', 'Longitudinal research and cross-sectional research'),
('OPTION_C', 'What is a SWOT analysis used for?', 8, 'To evaluate the taste of a product', 'To assess the internal strengths and weaknesses and external opportunities and threats of a business', 'To calculate the market share of a company', 'To determine the pricing strategy for a product');

-- Các câu hỏi cho bài học "Business Plan Development"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_B', 'What is a business plan?', 9, 'A plan for starting a business', 'A formal written document that describes the goals of a business, the methods for achieving those goals, and the timeframe for achieving them', 'A plan for expanding a business', 'A plan for selling a business'),
('OPTION_C', 'What is the purpose of a business plan?', 9, 'To attract investors', 'To guide the growth and development of a business', 'To increase competition', 'To reduce risks associated with starting a business'),
('OPTION_A', 'What are the key components of a business plan?', 9, 'Executive summary, company description, market analysis, organization and management, products and services, marketing and sales, funding request, financial projections', 'Introduction, body, conclusion', 'Mission statement, vision statement, goals and objectives', 'Sales forecast, balance sheet, income statement, cash flow statement');

-- Các câu hỏi cho bài học "Marketing and Sales Tactics"
INSERT INTO Question (answer, question_text, lesson_id, option_a, option_b, option_c, option_d) VALUES
('OPTION_D', 'What is marketing?', 10, 'The process of selling products', 'The process of manufacturing products', 'The process of distributing products', 'The process of promoting products and services'),
('OPTION_A', 'What are the 4Ps of marketing?', 10, 'Product, Price, Place, Promotion', 'Profit, Price, Promotion, Place', 'Product, Promotion, Publicity, Price', 'Price, Place, Promotion, Publicity'),
('OPTION_B', 'What is the purpose of a sales strategy?', 10, 'To increase production costs', 'To increase sales revenue and market share', 'To decrease customer satisfaction', 'To decrease brand loyalty');

INSERT INTO Student_answer (question_id, user_id, student_answer) VALUES
(1, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_B'),
(2, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_C'),
(3, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_A'),
(4, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_D'),
(5, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_B'),
(6, '9669a6a7-7e7e-4311-af05-f3e7b15ce7af', 'OPTION_A')
