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
                              user_id INT PRIMARY KEY AUTO_INCREMENT,
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
                               order_id INT PRIMARY KEY AUTO_INCREMENT,
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
                                 product_id INT PRIMARY KEY AUTO_INCREMENT,
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
                                          record_id INT PRIMARY KEY AUTO_INCREMENT,
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
    (2, 'Jane', 'Smith', 'jane.smith@example.com', '0987654321', '456 Elm St', 'Los Angeles', 'USA', '90001', '1995-02-15', 'Female', '2023-03-10', '2023-08-16', 10, 200),
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


INSERT INTO DBO_ProductInfo (product_id, product_name, category, brand, price, description, stock_quantity, image_url, manufacturing_date, expiry_date, weight, length, width, height, is_discontinued)
VALUES
    (1, 'iPhone 13', 'Electronics', 'Apple', 999, 'The latest iPhone model with advanced features.', 100, 'https://example.com/iphone13.jpg', '2023-01-01', '2025-01-01', 0.2, 14, 7, 1, 0),
    (2, 'Samsung Galaxy S21', 'Electronics', 'Samsung', 899, 'A powerful Android smartphone with a stunning display.', 150, 'https://example.com/galaxys21.jpg', '2023-02-01', '2024-02-01', 0.25, 15, 8, 2, 0),
    (3, 'Sony PlayStation 5', 'Electronics', 'Sony', 499, 'The next-generation gaming console from Sony.', 50, 'https://example.com/ps5.jpg', '2022-01-01', '2026-01-01', 4.5, 45, 30, 10, 0),
    (4, 'MacBook Pro', 'Electronics', 'Apple', 1499, 'A high-performance laptop by Apple.', 80, 'https://example.com/macbookpro.jpg', '2023-03-01', '2028-03-01', 1.5, 35, 25, 2, 0),
    (5, 'Samsung QLED TV', 'Electronics', 'Samsung', 1299, 'A premium smart TV with exceptional picture quality.', 120, 'https://example.com/qledtv.jpg', '2022-02-01', '2026-02-01', 30, 60, 10, 36, 0),
    (6, 'Nike Air Zoom Pegasus 38', 'Sports', 'Nike', 129, 'A popular running shoe with responsive cushioning.', 200, 'https://example.com/nikepegasus38.jpg', '2023-04-01', '2024-04-01', 0.3, 12, 6, 4, 0),
    (7, 'Adidas Ultraboost 21', 'Sports', 'Adidas', 149, 'A comfortable and stylish running shoe.', 180, 'https://example.com/adidasultraboost21.jpg', '2023-05-01', '2024-05-01', 0.35, 13, 7, 5, 0),
    (8, 'Yoga Mat', 'Sports', 'Unknown', 29, 'A nonslip and cushioned mat for yoga and fitness activities.', 300, 'https://example.com/yogamat.jpg', '2023-06-01', '2025-06-01', 1.2, 72, 24, 0.5, 0),
    (9, 'Dumbbell Set', 'Sports', 'Unknown', 99, 'A set of adjustable dumbbells for strength training.', 100, 'https://example.com/dumbbellset.jpg', '2023-07-01', '2024-07-01', 15, 12, 6, 4, 0),
    (10, 'Fitbit Charge 4', 'Electronics', 'Fitbit', 149, 'A fitness tracker with built-in GPS and heart rate monitoring.', 250, 'https://example.com/fitbitcharge4.jpg', '2023-08-01', '2025-08-01', 0.1, 10, 5, 1, 0),
    (11, 'Canon EOS R5', 'Electronics', 'Canon', 3499, 'A professional mirrorless camera with impressive image quality.', 30, 'https://example.com/canoneosr5.jpg', '2023-09-01', '2028-09-01', 1.5, 5, 4, 3, 0),
    (12, 'GoPro HERO9 Black', 'Electronics', 'GoPro', 349, 'A versatile action camera for capturing adventures.', 100, 'https://example.com/goprohero9.jpg', '2023-10-01', '2025-10-01', 0.25, 10, 5, 3, 0),
    (13, 'Nintendo Switch', 'Electronics', 'Nintendo', 299, 'A hybrid gaming console for playing at home or on the go.', 70, 'https://example.com/nintendoswitch.jpg', '2022-03-01', '2026-03-01', 1.2, 9, 5, 2, 0),
    (14, 'DJI Mavic Air 2', 'Electronics', 'DJI', 799, 'A compact and powerful drone with high-quality camera capabilities.', 40, 'https://example.com/djimavicair2.jpg', '2023-11-01', '2027-11-01', 0.4, 10, 8, 2, 0),
    (15, 'Apple Watch Series 6', 'Electronics', 'Apple', 399, 'A smartwatch that tracks your health and fitness.', 120, 'https://example.com/applewatch6.jpg', '2023-12-01', '2026-12-01', 0.1, 8, 4, 2, 0),
    (16, 'Mountain Bike', 'Sports', 'Unknown', 599, 'A durable and versatile bike for off-road adventures.', 60, 'https://example.com/mountainbike.jpg', '2023-01-01', '2025-01-01', 15, 160, 60, 100, 0),
    (17, 'Treadmill', 'Sports', 'Unknown', 999, 'A motorized treadmill for indoor running and walking workouts.', 30, 'https://example.com/treadmill.jpg', '2023-02-01', '2024-02-01', 80, 180, 70, 150, 0),
    (18, 'Basketball', 'Sports', 'Unknown', 39, 'A high-quality basketball suitable for both indoor and outdoor use.', 150, 'https://example.com/basketball.jpg', '2022-01-01', '2026-01-01', 0.6, 9, 9, 9, 0),
    (19, 'Golf Club Set', 'Sports', 'Unknown', 799, 'A complete set of golf clubs for players of all skill levels.', 20, 'https://example.com/golfclubset.jpg', '2023-03-01', '2028-03-01', 10, 48, 24, 6, 0),
    (20, 'Camping Tent', 'Sports', 'Unknown', 199, 'A spacious tent for outdoor camping and adventure.', 80, 'https://example.com/campingtent.jpg', '2022-02-01', '2026-02-01', 4, 84, 84, 48, 0),
    (21, 'Wireless Earbuds', 'Electronics', 'Unknown', 129, 'True wireless earbuds with long battery life and excellent sound quality.', 200, 'https://example.com/earbuds.jpg', '2023-01-01', '2025-01-01', 0.2, 14, 7, 1, 0),
    (22, 'Smart TV', 'Electronics', 'Unknown', 799, 'A smart television with built-in streaming capabilities.', 50, 'https://example.com/smarttv.jpg', '2023-02-01', '2024-02-01', 25, 60, 10, 30, 0),
    (23, 'Wireless Keyboard and Mouse Set', 'Electronics', 'Unknown', 49, 'A keyboard and mouse set with wireless connectivity.', 120, 'https://example.com/keyboardmouse.jpg', '2022-01-01', '2026-01-01', 1, 18, 5, 2, 0),
    (24, 'Bluetooth Speaker', 'Electronics', 'Unknown', 59, 'A portable speaker with Bluetooth connectivity.', 200, 'https://example.com/bluetoothspeaker.jpg', '2023-03-01', '2028-03-01', 0.4, 10, 8, 2, 0),
    (25, 'Fitness Resistance Bands Set', 'Sports', 'Unknown', 19, 'A set of elastic bands for strength and resistance training.', 100, 'https://example.com/resistancebands.jpg', '2022-02-01', '2026-02-01', 0.5, 10, 3, 1, 0),
    (26, 'Tennis Racket', 'Sports', 'Unknown', 99, 'A lightweight racket for tennis enthusiasts.', 80, 'https://example.com/tennisracket.jpg', '2023-04-01', '2024-04-01', 0.3, 27, 9, 2, 0),
    (27, 'Running Shorts', 'Sports', 'Unknown', 29, 'Comfortable shorts for running and athletic activities.', 150, 'https://example.com/runningshorts.jpg', '2023-05-01', '2024-05-01', 0.15, 11, 6, 1, 0),
    (28, 'Wireless Headphones', 'Electronics', 'Unknown', 79, 'High-quality headphones with wireless connectivity.', 300, 'https://example.com/wirelessheadphones.jpg', '2023-06-01', '2025-06-01', 0.2, 17, 16, 8, 0),
    (29, 'Cycling Helmet', 'Sports', 'Unknown', 39, 'A protective helmet for cycling and other outdoor sports.', 100, 'https://example.com/cyclinghelmet.jpg', '2023-07-01', '2024-07-01', 0.5, 10, 8,8,0),
    (30, 'Wireless Charger', 'Electronics', 'Unknown', 29, 'A convenient wireless charger for compatible devices.', 200, 'https://example.com/wirelesscharger.jpg', '2023-08-01', '2025-08-01', 0.1, 8, 4, 2, 0),
    (31, 'Yoga Block', 'Sports', 'Unknown', 19, 'A foam block for support and stability during yoga and Pilates.', 120, 'https://example.com/yogablock.jpg', '2023-09-01', '2024-09-01', 0.3, 9, 6, 3, 0),
    (32, 'Weightlifting Gloves', 'Sports', 'Unknown', 19, 'Padded gloves for weightlifting and strength training.', 100, 'https://example.com/weightliftinggloves.jpg', '2023-10-01', '2024-10-01', 0.1, 7, 11, 2, 0),
    (33, 'Hiking Backpack', 'Sports', 'Unknown', 79, 'A durable backpack for hiking and outdoor adventures.', 80, 'https://example.com/hikingbackpack.jpg', '2023-11-01', '2025-11-01', 1.5, 22, 14, 9, 0),
    (34, 'Wireless Gaming Mouse', 'Electronics', 'Unknown', 49, 'A high-performance mouse for gaming enthusiasts.', 50, 'https://example.com/gamingmouse.jpg', '2023-12-01', '2025-12-01', 0.15, 12, 6, 4, 0),
    (35, 'Ski Goggles', 'Sports', 'Unknown', 49, 'Snow goggles with UV protection for skiing and snowboarding.', 150, 'https://example.com/skigoggles.jpg', '2023-01-01', '2025-01-01', 0.3, 18, 8, 10, 0),
    (36, 'Electric Toothbrush', 'Electronics', 'Unknown', 39, 'A rechargeable toothbrush for effective oral care.', 120, 'https://example.com/electrictoothbrush.jpg', '2023-02-01', '2024-02-01', 0.2, 9, 3, 1, 0),
    (37, 'Swimming Goggles', 'Sports', 'Unknown', 19, 'Goggles with anti-fog lenses for swimming and water sports.', 100, 'https://example.com/swimminggoggles.jpg', '2022-03-01', '2026-03-01', 0.1, 7, 3, 2, 0),
    (38, 'Foldable Bike', 'Sports', 'Unknown', 399, 'A compact and portable bike for commuting and urban riding.', 50, 'https://example.com/foldablebike.jpg', '2023-04-01', '2024-04-01', 12, 160, 60, 100, 0),
    (39, 'Portable Power Bank', 'Electronics', 'Unknown', 29, 'A portable charger for smartphones and other devices.', 200, 'https://example.com/powerbank.jpg', '2023-05-01', '2024-05-01', 0.15, 10, 5, 2, 0),
    (40, 'Compression Socks', 'Sports', 'Unknown', 19, 'Socks that provide support and improve circulation during workouts.', 150, 'https://example.com/compressionsocks.jpg', '2023-06-01', '2024-06-01', 0.1, 8, 4, 1, 0),
    (41, 'Wireless Security Camera', 'Electronics', 'Unknown', 99, 'A wireless camera for home security and surveillance.', 80, 'https://example.com/securitycamera.jpg', '2023-07-01', '2024-07-01', 0.25, 10, 8, 4, 0),
    (42, 'Jump Rope', 'Sports', 'Unknown', 19, 'A lightweight and adjustable rope for cardio and fitness training.', 100, 'https://example.com/jumprope.jpg', '2023-08-01', '2025-08-01', 0.2, 9, 2, 2, 0),
    (43, 'Electric Scooter', 'Sports', 'Unknown', 399, 'A compact and electric scooter for short commutes and leisure rides.', 30, 'https://example.com/electricscooter.jpg', '2023-09-01', '2024-09-01', 15, 100, 50, 15, 0),
    (44, 'Bluetooth Earphones', 'Electronics', 'Unknown', 69, 'Wireless earphones with Bluetooth connectivity for music and calls.', 200, 'https://example.com/bluetoothearphones.jpg', '2023-10-01', '2025-10-01', 0.1, 8, 4, 2, 0),
    (45, 'Soccer Ball', 'Sports', 'Unknown', 29, 'A classic soccer ball suitable for both training and matches.', 150, 'https://example.com/soccerball.jpg', '2023-11-01', '2024-11-01', 0.6, 9, 9, 9, 0),
    (46, 'Smart Home Hub', 'Electronics', 'Unknown', 149, 'A central hub for controlling smart home devices.', 40, 'https://example.com/smarthomehub.jpg', '2023-12-01', '2027-12-01', 0.4, 10, 8, 2, 0),
    (47, 'Cycling Jersey', 'Sports', 'Unknown', 49, 'A lightweight and breathable jersey for cycling enthusiasts.', 100, 'https://example.com/cyclingjersey.jpg', '2022-01-01', '2026-01-01', 0.2, 7, 4, 1, 0),
    (48, 'Sleeping Bag', 'Sports', 'Unknown', 79, 'A warm and comfortable sleeping bag for camping and outdoor use.', 80, 'https://example.com/sleepingbag.jpg', '2023-02-01', '2024-02-01', 1.5, 20, 12, 8, 0),
    (49, 'Wireless Presenter', 'Electronics', 'Unknown', 29, 'A wireless presenter for professional presentations.', 50, 'https://example.com/wirelesspresenter.jpg', '2023-03-01', '2024-03-01', 0.1, 10, 5, 2, 0),
    (50, 'Tennis Ball', 'Sports', 'Unknown', 9, 'A durable ball for tennis practice and matches.', 200, 'https://example.com/tennisball.jpg', '2022-02-01', '2026-02-01', 0.1, 8, 8, 8, 0);


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