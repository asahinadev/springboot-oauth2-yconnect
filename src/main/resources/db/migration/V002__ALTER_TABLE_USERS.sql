ALTER TABLE `users` 
	ADD `dispname`    VARCHAR(255) CHARACTER SET utf8mb4 COMMENT '表示名',
	ADD `family_name` VARCHAR(255) CHARACTER SET utf8mb4 COMMENT '氏名・姓',
	ADD `last_name`   VARCHAR(255) CHARACTER SET utf8mb4 COMMENT '氏名・名',
	ADD `gender`      INT                                COMMENT '性別',
	ADD `time_zone`   VARCHAR(255)                       COMMENT 'タイムゾーン',
	ADD `locale`      VARCHAR(255)                       COMMENT 'ロケール',
	ADD `birth_year`  INT                                COMMENT '誕生日（年）',
	ADD `birth_month` INT                                COMMENT '誕生日（月）',
	ADD `birth_day`   INT                                COMMENT '誕生日（日）',
	ADD `picture`     VARCHAR(255)                       COMMENT 'プロフィール画像',
	ADD `country`     VARCHAR(50)                        COMMENT '国',
	ADD `post_code`   VARCHAR(50)                        COMMENT '郵便番号',
	ADD `region`      VARCHAR(50) CHARACTER SET utf8mb4  COMMENT '都道府県',
	ADD `location`    VARCHAR(50) CHARACTER SET utf8mb4  COMMENT '市区町村',
	ADD `address1`    VARCHAR(50) CHARACTER SET utf8mb4  COMMENT '町域',
	ADD `address2`    VARCHAR(50) CHARACTER SET utf8mb4  COMMENT '建物',
	ADD `address3`    VARCHAR(50) CHARACTER SET utf8mb4  COMMENT '補記'
;