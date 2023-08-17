CREATE TABLE obo_User (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          username VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL
);



CREATE TABLE obo_Role (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          permissions VARCHAR(255)
);

CREATE TABLE obo_Permission (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                name VARCHAR(255) NOT NULL,
                                description VARCHAR(255)
);

CREATE TABLE obo_Article (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             title VARCHAR(255) NOT NULL,
                             content TEXT,
                             author_id INT NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE obo_Category (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              name VARCHAR(255) NOT NULL,
                              parent_id INT,
                              FOREIGN KEY (parent_id) REFERENCES obo_Category(id)
);

CREATE TABLE obo_Tag (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE obo_Comment (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             article_id INT NOT NULL,
                             user_id INT NOT NULL,
                             content TEXT,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE obo_File (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          filename VARCHAR(255) NOT NULL,
                          filepath VARCHAR(255) NOT NULL,
                          size INT,
                          uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE obo_Page (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          content TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE obo_Log (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         user_id INT NOT NULL,
                         timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         action VARCHAR(255)
);

INSERT INTO obo_User (username, password, email) VALUES
                                                     ('观音菩萨', 'guanyinpusa', 'guanyin@example.com'),
                                                     ('如来佛祖', 'rulaifozu', 'rulaifo@example.com'),
                                                     ('玉帝', 'yudi', 'yudi@example.com'),
                                                     ('二郎神', 'erlangshen', 'erlangshen@example.com'),
                                                     ('牛魔王', 'niumowang', 'niumowang@example.com'),
                                                     ('蜘蛛精', 'zhizhujing', 'zhizhujing@example.com'),
                                                     ('白骨精', 'baigujing', 'baigujing@example.com'),
                                                     ('红孩儿', 'honghaier', 'honghaier@example.com'),
                                                     ('铁扇公主', 'tieshangongzhu', 'tieshangongzhu@example.com'),
                                                     ('沙和尚', 'shaheshang', 'shaheshang@example.com'),
                                                     ('六耳猕猴', 'liuermihou', 'liuermihou@example.com'),
                                                     ('金角大王', 'jinjiaodawang', 'jinjiaodawang@example.com'),
                                                     ('银角大王', 'yinjiaodawang', 'yinjiaodawang@example.com'),
                                                     ('真君', 'zhenjun', 'zhenjun@example.com'),
                                                     ('太上老君', 'taishanglaojun', 'taishanglaojun@example.com'),
                                                     ('东海龙王', 'donghailongwang', 'donghailongwang@example.com'),
                                                     ('西海龙王', 'xihailongwang', 'xihailongwang@example.com'),
                                                     ('南海龙王', 'nanhailongwang', 'nanhailongwang@example.com'),
                                                     ('北海龙王', 'beihailongwang', 'beihailongwang@example.com'),
                                                     ('蛟龙王', 'jiaolongwang', 'jiaolongwang@example.com'),
                                                     ('狮驼王', 'shitouwang', 'shitouwang@example.com'),
                                                     ('九头虫', 'jiutouchong', 'jiutouchong@example.com'),
                                                     ('黑风怪', 'heifengguai', 'heifengguai@example.com'),
                                                     ('黄袍怪', 'huangpaoguai', 'huangpaoguai@example.com'),
                                                     ('羊头怪', 'yangtouguai', 'yangtouguai@example.com'),
                                                     ('白骨精', 'baigujing', 'baigujing@example.com'),
                                                     ('铁扇公主', 'tieshangongzhu', 'tieshangongzhu@example.com'),
                                                     ('玉面公主', 'yumiangongzhu', 'yumiangongzhu@example.com'),
                                                     ('二郎神', 'erlangshen', 'erlangshen@example.com'),
                                                     ('三太子', 'santaizi', 'santaizi@example.com'),
                                                     ('孙悟空', 'sunwukong', 'sunwukong@example.com'),
                                                     ('猪八戒', 'zhubajie', 'zhubajie@example.com'),
                                                     ('沙悟净', 'shawujing', 'shawujing@example.com'),
                                                     ('白龙马', 'bailongma', 'bailongma@example.com'),
                                                     ('悟空大师', 'wukongdashi', 'wukongdashi@example.com'),
                                                     ('菩提祖师', 'putizushi', 'putizushi@example.com'),
                                                     ('木叉大王', 'muchadawang', 'muchadawang@example.com'),
                                                     ('太上老君', 'taishanglaojun', 'taishanglaojun@example.com'),
                                                     ('凤凰精', 'fenghuangjing', 'fenghuangjing@example.com'),
                                                     ('五行山', 'wuxingshan', 'wuxingshan@example.com'),
                                                     ('火焰山', 'huoyanshan', 'huoyanshan@example.com'),
                                                     ('盘丝洞', 'pansidong', 'pansidong@example.com'),
                                                     ('流沙河', 'liushahe', 'liushahe@example.com'),
                                                     ('花果山', 'huaguoshan', 'huaguoshan@example.com'),
                                                     ('水帘洞', 'shuilindong', 'shuilindong@example.com'),
                                                     ('白虎山', 'baihushan', 'baihushan@example.com'),
                                                     ('碧波潭', 'bibotan', 'bibotan@example.com'),
                                                     ('三界山', 'sanjieshan', 'sanjieshan@example.com'),
                                                     ('紫霄宫', 'zixiaogong', 'zixiaogong@example.com');

CREATE TABLE DBO_UserInfo (
                              user_id INT PRIMARY KEY,
                              first_name VARCHAR(50),
                              last_name VARCHAR(50),
                              email VARCHAR(100),
                              phone VARCHAR(20),
                              address VARCHAR(255),
                              city VARCHAR(50),
                              country VARCHAR(50),
                              postal_code VARCHAR(10),
                              date_of_birth DATE,
                              gender VARCHAR(10),
                              registration_date DATE,
                              last_login_date DATE,
                              total_orders INT,
                              loyalty_points INT
);

CREATE TABLE DBO_OrderInfo (
                               order_id INT PRIMARY KEY,
                               user_id INT,
                               order_date DATE,
                               total_amount DECIMAL(15, 2),
                               shipping_address VARCHAR(255),
                               shipping_city VARCHAR(50),
                               shipping_country VARCHAR(50),
                               shipping_postal_code VARCHAR(10),
                               payment_method VARCHAR(50),
                               transaction_id VARCHAR(50),
                               is_paid BOOLEAN,
                               is_shipped BOOLEAN,
                               shipping_date DATE,
                               delivery_date DATE,
                               special_instructions VARCHAR(255),
                               FOREIGN KEY (user_id) REFERENCES DBO_UserInfo(user_id)
);


CREATE TABLE DBO_ProductInfo (
                                 product_id INT PRIMARY KEY,
                                 product_name VARCHAR(100),
                                 category VARCHAR(50),
                                 brand VARCHAR(50),
                                 price DECIMAL(10, 2),
                                 description VARCHAR(255),
                                 stock_quantity INT,
                                 image_url VARCHAR(255),
                                 manufacturing_date DATE,
                                 expiry_date DATE,
                                 weight DECIMAL(10, 2),
                                 length DECIMAL(10, 2),
                                 width DECIMAL(10, 2),
                                 height DECIMAL(10, 2),
                                 is_discontinued BOOLEAN
);

CREATE TABLE DBO_Order_Product_Record (
                                          record_id INT PRIMARY KEY,
                                          order_id INT,
                                          product_id INT,
                                          user_id INT,
                                          quantity INT,
                                          unit_price DECIMAL(10, 2),
                                          total_price DECIMAL(15, 2),
                                          discount DECIMAL(5, 2),
                                          tax DECIMAL(5, 2),
                                          shipping_fee DECIMAL(10, 2),
                                          returned BOOLEAN,
                                          return_reason VARCHAR(255),
                                          return_date DATE,
                                          FOREIGN KEY (order_id) REFERENCES DBO_OrderInfo(order_id),
                                          FOREIGN KEY (product_id) REFERENCES DBO_ProductInfo(product_id),
                                          FOREIGN KEY (user_id) REFERENCES DBO_UserInfo(user_id)
);

INSERT INTO DBO_UserInfo (user_id, first_name, last_name, email, phone, address, city, country, postal_code, date_of_birth, gender, registration_date, last_login_date, total_orders, loyalty_points)
VALUES
    (1, 'John', 'Doe', 'john.doe@example.com', '1234567890', '123 Main St', 'New York', 'USA', '10001', '1990-01-01', 'Male', '2023-01-01', '2023-08-15', 5, 100),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', '0987654321', '456 Elm St', 'Los Angeles', 'USA', '90001', '1995-02-15', 'Female', '2023-03-10', '2023-08-16', 10, 200)
    (3, 'David', 'Johnson', 'david.johnson@example.com', '9876543210', '789 Oak Ave', 'Chicago', 'USA', '60601', '1988-12-15', 'Male', '2023-02-20', '2023-08-14', 3, 50),
    (4, 'Emily', 'Brown', 'emily.brown@example.com', '5432167890', '321 Pine St', 'San Francisco', 'USA', '94101', '1992-07-18', 'Female', '2023-05-05', '2023-08-13', 8, 150),
    (5, 'Michael', 'Miller', 'michael.miller@example.com', '0123456789', '567 Maple Ave', 'Seattle', 'USA', '98101', '1991-04-25', 'Male', '2023-02-28', '2023-08-12', 6, 120),
    (6, 'Olivia', 'Wilson', 'olivia.wilson@example.com', '9876541230', '987 Oak St', 'Dallas', 'USA', '75201', '1994-09-12', 'Female', '2023-07-01', '2023-08-11', 4, 80),
    (7, 'James', 'Jones', 'james.jones@example.com', '4567890123', '654 Cedar Rd', 'Boston', 'USA', '02101', '1989-03-22', 'Male', '2023-04-15', '2023-08-10', 2, 30),
    (8, 'Sophia', 'Taylor', 'sophia.taylor@example.com', '7890123456', '876 Walnut Ave', 'Miami', 'USA', '33101', '1993-11-06', 'Female', '2023-06-20', '2023-08-09', 7, 140),
    (9, 'Alexander', 'Anderson', 'alexander.anderson@example.com', '5678901234', '234 Oak St', 'Houston', 'USA', '77001', '1990-08-08', 'Male', '2023-01-15', '2023-08-08', 9, 180),
    (10, 'Isabella', 'Thomas', 'isabella.thomas@example.com', '4321098765', '543 Elm Rd', 'Phoenix', 'USA', '85001', '1997-06-30', 'Female', '2023-08-05', '2023-08-07', 12, 240),
    (11, 'William', 'Harris', 'william.harris@example.com', '8901234567', '987 Maple St', 'Denver', 'USA', '80201', '1987-09-26', 'Male', '2023-03-05', '2023-08-06', 1, 10),
    (12, 'Mia', 'Clark', 'mia.clark@example.com', '3210987654', '765 Cedar Ave', 'Atlanta', 'USA', '30301', '1996-12-03', 'Female', '2023-07-10', '2023-08-05', 11, 220),
    (13, 'Henry', 'Lewis', 'henry.lewis@example.com', '6789054321', '345 Elm Rd', 'San Diego', 'USA', '92101', '1998-02-28', 'Male', '2023-08-02', '2023-08-04', 14, 280),
    (14, 'Ava', 'Lee', 'ava.lee@example.com', '5432109876', '876 Pine St', 'Washington D.C.', 'USA', '20001', '1992-05-14', 'Female', '2023-05-20', '2023-08-03', 13, 260),
    (15, 'Joseph', 'Walker', 'joseph.walker@example.com', '9012345678', '654 Oak Ave', 'Las Vegas', 'USA', '89101', '1988-08-18', 'Male', '2023-02-10', '2023-08-02', 15, 300),
    (16, 'Chloe', 'Gonzalez', 'chloe.gonzalez@example.com', '4567890123', '123 Cedar St', 'Orlando', 'USA', '32801', '1995-01-09', 'Female', '2023-04-25', '2023-08-01', 16, 320),
    (17, 'Daniel', 'Hall', 'daniel.hall@example.com', '0123456789', '567 Pine Ave', 'Philadelphia', 'USA', '19101', '1991-10-20', 'Male', '2023-03-15', '2023-07-31', 18, 360),
    (18, 'Ella', 'Young', 'ella.young@example.com', '9876543210', '890 Elm Rd', 'San Antonio', 'USA', '78201', '1994-07-07', 'Female', '2023-06-05', '2023-07-30', 17, 340),
    (19, 'Benjamin', 'Lopez', 'benjamin.lopez@example.com', '6789012345', '543 Oak Ave', 'Austin', 'USA', '73301', '1993-04-16', 'Male', '2023-05-01', '2023-07-29', 19, 380),
    (20, 'Sofia', 'Clark', 'sofia.clark@example.com', '8901234567', '765 Pine St', 'Detroit', 'USA', '48201', '1997-03-28', 'Female', '2023-08-10', '2023-07-28', 20, 400);




INSERT INTO DBO_ProductInfo (product_id, product_name, description, category, price, stock)
VALUES
    (1, 'iPhone 13', 'The latest iPhone model with advanced features.', 'Electronics', 999, 100),
    (2, 'Samsung Galaxy S21', 'A powerful Android smartphone with a stunning display.', 'Electronics', 899, 150),
    (3, 'Sony PlayStation 5', 'The next-generation gaming console from Sony.', 'Electronics', 499, 50),
    (4, 'MacBook Pro', 'A high-performance laptop by Apple.', 'Electronics', 1499, 80),
    (5, 'Samsung QLED TV', 'A premium smart TV with exceptional picture quality.', 'Electronics', 1299, 120),
    (6, 'Nike Air Zoom Pegasus 38', 'A popular running shoe with responsive cushioning.', 'Sports', 129, 200),
    (7, 'Adidas Ultraboost 21', 'A comfortable and stylish running shoe.', 'Sports', 149, 180),
    (8, 'Yoga Mat', 'A nonslip and cushioned mat for yoga and fitness activities.', 'Sports', 29, 300),
    (9, 'Dumbbell Set', 'A set of adjustable dumbbells for strength training.', 'Sports', 99, 100),
    (10, 'Fitbit Charge 4', 'A fitness tracker with built-in GPS and heart rate monitoring.', 'Electronics', 149, 250),
    (11, 'Canon EOS R5', 'A professional mirrorless camera with impressive image quality.', 'Electronics', 3499, 30),
    (12, 'GoPro HERO9 Black', 'A versatile action camera for capturing adventures.', 'Electronics', 349, 100),
    (13, 'Nintendo Switch', 'A hybrid gaming console for playing at home or on the go.', 'Electronics', 299, 70),
    (14, 'DJI Mavic Air 2', 'A compact and powerful drone with high-quality camera capabilities.', 'Electronics', 799, 40),
    (15, 'Apple Watch Series 6', 'A smartwatch that tracks your health and fitness.', 'Electronics', 399, 120),
    (16, 'Mountain Bike', 'A durable and versatile bike for off-road adventures.', 'Sports', 599, 60),
    (17, 'Treadmill', 'A motorized treadmill for indoor running and walking workouts.', 'Sports', 999, 30),
    (18, 'Basketball', 'A high-quality basketball suitable for both indoor and outdoor use.', 'Sports', 39, 150),
    (19, 'Golf Club Set', 'A complete set of golf clubs for players of all skill levels.', 'Sports', 799, 20),
    (20, 'Camping Tent', 'A spacious tent for outdoor camping and adventure.', 'Sports', 199, 80),
    (21, 'Wireless Earbuds', 'True wireless earbuds with long battery life and excellent sound quality.', 'Electronics', 129, 200),
    (22, 'Bluetooth Speaker', 'A portable speaker with wireless connectivity for music playback.', 'Electronics', 79, 300),
    (23, 'Yoga Block', 'A supportive block used in yoga and stretching exercises.', 'Sports', 19, 400),
    (24, 'Jump Rope', 'A lightweight and durable rope for cardiovascular exercise.', 'Sports', 9, 500),
    (25, 'Resistance Bands', 'A set of bands for strength training and rehabilitation exercises.', 'Sports', 49, 200),
    (26, 'Wireless Mouse', 'An ergonomic mouse with wireless connectivity for comfortable computer use.', 'Electronics', 29, 400),
    (27, 'External Hard Drive', 'A portable storage device for backing up and transferring files.', 'Electronics', 99, 150),
    (28, 'Yoga Mat Bag', 'A convenient bag for carrying and storing yoga mats.', 'Sports', 19, 300),
    (29, 'Gym Gloves', 'Padded gloves to protect hands during weightlifting and gym workouts.', 'Sports', 19, 200),
    (30, 'Smart TV Stick', 'A device that turns your TV into a smart TV with streaming capabilities.', 'Electronics', 49, 250),
    (31, 'Running Shorts', 'Lightweight and breathable shorts for running and fitness activities.', 'Sports', 39, 300),
    (32, 'Tennis Racket', 'A high-quality racket for tennis players of all skill levels.', 'Sports', 129, 100),
    (33, 'Portable Charger', 'A compact power bank for charging devices on the go.', 'Electronics', 29, 400),
    (34, 'Swimming Goggles', 'Goggles designed for comfortable and clear underwater vision.', 'Sports', 19, 250),
    (35, 'Fitness Tracker', 'A wearable device that tracks your activity, heart rate, and sleep.', 'Electronics', 79, 200),
    (36, 'Golf Balls', 'High-performance golf balls for distance and control.', 'Sports', 29, 300),
    (37, 'Dumbbell Rack', 'A sturdy rack for organizing and storing dumbbells.', 'Sports', 79, 100),
    (38, 'Cycling Helmet', 'A helmet that provides protection and ventilation during cycling.', 'Sports', 49, 200),
    (39, 'Portable Bluetooth Keyboard', 'A portable keyboard for convenient typing on smartphones and tablets.', 'Electronics', 59, 150),
    (40, 'Hiking Backpack', 'A spacious backpack with multiple compartments for hiking and camping.', 'Sports', 99, 100),
    (41, 'Smart Thermostat', 'A smart device for controlling and scheduling home heating and cooling.', 'Electronics', 149, 80),
    (42, 'Fitness Exercise Ball', 'A versatile ball for core and balance exercises.', 'Sports', 29, 300),
    (43, 'Cycling Gloves', 'Padded gloves for comfort and grip during cycling.', 'Sports', 19, 250),
    (44, 'Wireless Headphones', 'Bluetooth headphones with noise cancellation and long battery life.', 'Electronics', 129, 180),
    (45, 'Soccer Ball', 'A durable and high-quality ball for soccer matches and training.', 'Sports', 29, 400),
    (46, 'Gym Bag', 'A spacious bag for carrying gym clothes and equipment.', 'Sports', 49, 200),
    (47, 'Soundbar', 'A compact speaker system for enhanced TV and music audio.', 'Electronics', 149, 120),
    (48, 'Yoga Strap', 'A strap that helps improve flexibility and deepen yoga poses.', 'Sports', 9, 500),
    (49, 'Weight Bench', 'A sturdy bench for weightlifting and strength training exercises.', 'Sports', 199, 60),
    (50, 'Virtual Reality Headset', 'An immersive headset for virtual reality gaming and experiences.', 'Electronics', 299, 40);
INSERT INTO DBO_OrderInfo (order_id, user_id, order_date, total_amount, shipping_address, shipping_city, shipping_country, shipping_postal_code, payment_method, transaction_id, is_paid, is_shipped, shipping_date, delivery_date, special_instructions) VALUES
                                                                                                                                                                                                                                                              (1, 1, '2023-08-01', 150.00, '123 Main St', 'City A', 'Country A', '12345', 'Credit Card', 'ABC123', true, true, '2023-08-02', '2023-08-05', 'Handle with care'),
                                                                                                                                                                                                                                                              (2, 1, '2023-08-10', 200.00, '456 Elm St', 'City B', 'Country B', '67890', 'PayPal', 'DEF456', true, true, '2023-08-11', '2023-08-15', ''),
                                                                                                                                                                                                                                                              (3, 2, '2023-08-02', 100.00, '789 Oak St', 'City C', 'Country C', '54321', 'Credit Card', 'GHI789', true, false, null, null, 'Fragile items'),
                                                                                                                                                                                                                                                              (4, 3, '2023-08-05', 50.00, '321 Maple St', 'City D', 'Country D', '09876', 'PayPal', 'JKL012', true, true, '2023-08-06', '2023-08-08', ''),
                                                                                                                                                                                                                                                              (5, 4, '2023-08-07', 120.00, '654 Pine St', 'City E', 'Country E', '56789', 'Credit Card', 'MNO345', true, true, '2023-08-08', '2023-08-12', ''),
                                                                                                                                                                                                                                                              (6, 5, '2023-08-12', 80.00, '987 Cedar St', 'City F', 'Country F', '43210', 'PayPal', 'PQR678', true, false, null, null, ''),
                                                                                                                                                                                                                                                              (7, 5, '2023-08-15', 60.00, '456 Birch St', 'City G', 'Country G', '10987', 'Credit Card', 'STU901', true, true, '2023-08-16', '2023-08-20', ''),
                                                                                                                                                                                                                                                              (8, 6, '2023-08-03', 90.00, '789 Walnut St', 'City H', 'Country H', '89012', 'PayPal', 'VWX234', true, true, '2023-08-04', '2023-08-07', 'Please expedite'),
                                                                                                                                                                                                                                                              (9, 7, '2023-08-09', 70.00, '123 Spruce St', 'City I', 'Country I', '21098', 'Credit Card', 'YZA567', true, true, '2023-08-10', '2023-08-14', ''),
                                                                                                                                                                                                                                                              (10, 8, '2023-08-11', 180.00, '456 Oak St', 'City J', 'Country J', '76543', 'PayPal', 'BCD890', true, true, '2023-08-12', '2023-08-16', 'None');
select * from DBO_OrderInfo;


INSERT INTO DBO_Order_Product_Record (record_id, order_id, product_id, user_id, quantity, unit_price, total_price, discount, tax, shipping_fee, returned, return_reason, return_date) VALUES
                                                                                                                                                                                          (1, 1, 1, 1, 2, 50.00, 100.00, 0.00, 10.00, 5.00, false, null, null),
                                                                                                                                                                                          (2, 1, 3, 1, 1, 30.00, 30.00, 0.00, 3.00, 5.00, false, null, null),
                                                                                                                                                                                          (3, 2, 2, 1, 3, 40.00, 120.00, 10.00, 6.00, 8.00, false, null, null),
                                                                                                                                                                                          (4, 3, 4, 2, 1, 50.00, 50.00, 0.00, 5.00, 5.00, false, null, null),
                                                                                                                                                                                          (5, 4, 5, 3, 2, 60.00, 120.00, 0.00, 6.00, 5.00, true, 'Wrong size', '2023-08-07'),
                                                                                                                                                                                          (6, 5, 6, 4, 1, 70.00, 70.00, 0.00, 7.00, 5.00, false, null, null),
                                                                                                                                                                                          (7, 6, 7, 5, 4, 20.00, 80.00, 0.00, 8.00, 5.00, false, null, null),
                                                                                                                                                                                          (8, 7, 8, 5, 1, 30.00, 30.00, 0.00, 3.00, 5.00, false, null, null),
                                                                                                                                                                                          (9, 8, 9, 6, 3, 40.00, 120.00, 0.00, 6.00, 5.00, true, 'Defective', '2023-08-05'),
                                                                                                                                                                                          (10, 9, 10, 7, 2, 25.00, 50.00, 0.00, 5.00, 5.00, false, null, null);