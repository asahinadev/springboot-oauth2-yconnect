CREATE TABLE IF NOT EXISTS `users` ( 
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `username` VARCHAR (255) NOT NULL COMMENT 'アカウント'
  , `email` VARCHAR (255)  NOT NULL COMMENT 'メールアドレス'
  , `password` VARCHAR(255)   NOT NULL COMMENT 'パスワード'
  , `enable` CHAR (1) NOT NULL DEFAULT '0' COMMENT '有効状態'
  , `locked` CHAR (1) NOT NULL DEFAULT '0' COMMENT 'ロック状態'
  , `lock_count` INT NOT NULL DEFAULT 0 COMMENT 'ロックカウント'
  , `account_expiration` DECIMAL NULL COMMENT 'アカウント有効期限'
  , `password_expiration` INT NULL COMMENT 'パスワード有効期限'
  , `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時'
  , `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時'
  , PRIMARY KEY (`id`)
  , UNIQUE `idx_users_username` (`username`)
  , UNIQUE `idx_users_email` (`email`)
) ENGINE = InnoDB CHARSET = ascii COLLATE ascii_bin COMMENT = 'ユーザー';
