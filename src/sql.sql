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

