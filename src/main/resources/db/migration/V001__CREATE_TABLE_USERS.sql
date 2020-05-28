CREATE TABLE IF NOT EXISTS `users` ( 
  `id` INT                    NOT NULL AUTO_INCREMENT             COMMENT '識別子'
  , `username` VARCHAR (255)  NOT NULL                            COMMENT 'アカウント'
  , `email` VARCHAR (255)     NOT NULL                            COMMENT 'メールアドレス'
  , `password` VARCHAR(255)   NOT NULL                            COMMENT 'パスワード'
  , `created` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時'
  , `updated` DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時'
  , `deleted` DATETIME                                            COMMENT '削除日時'
  , PRIMARY KEY (`id`)
  , UNIQUE `idx_users_username` (`username`)
  , UNIQUE `idx_users_email` (`email`)
) ENGINE = InnoDB CHARSET = ascii COLLATE ascii_bin COMMENT = 'ユーザー情報';
