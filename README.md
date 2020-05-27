# springboot-oauth2-yconnect

## 関連リンク

* [Yahoo! ID連携 v2](https://developer.yahoo.co.jp/yconnect/v2/)
* [アプリケーション取得](https://e.developer.yahoo.co.jp/dashboard/)

## 登録データ

| キー名 | 内容 |
|---|---|
| アプリケーション名 | 任意の名前 |
| サイトURL | 任意の名前 |
| コールバックURL | baseUrl}/login/oauth2/code/yconnect |

## 起動オプション

* -Dspring.security.oauth2.client.registration.yconnect.client-id
* -Dspring.security.oauth2.client.registration.yconnect.client-secret
    
    
