package com.example.spring.yconnect.dto;

import com.example.spring.yconnect.validation.FromTo;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@FromTo.List({
		@FromTo(from = "minprice", to = "maxprice")
})
public class LocalSearchRequest {
//	appid
//	（必須）	string	アプリケーションID。詳細はこちらをご覧ください。
//	device	string	APIの結果をモバイル端末に掲載する場合は「mobile」を指定してください。モバイル端末で掲載できない情報が非表示になります。
//	query	string	（UTF-8でエンコードされた）検索クエリーです。検索対象は、地域・拠点情報名称および業種（カセットによってはない場合があります）です。
//	cid	string	カセットIDです。カセットIDを用いて店舗データを検索できます。
//	コンマ「,」区切りで複数指定が可能です。
//	電話帳のcidは「d8a23e9e64a4c817227ab09858bc1330」です。
//	指定しない場合は、公開されているカセット全体が検索対象です。
//	uid	string	ユニークIDです。
//	コンマ「,」区切りで複数指定できます。
//	gid	string	名寄せされた店舗IDです。
//	コンマ「,」区切りで複数指定が可能です。
//	id	string	カセット内で設定されたIDです。
//	コンマ「,」区切りで複数指定が可能です。
//	※カセットID（cid）と併せてご利用ください。
//	bid	string	ビルIDです。
//	コンマ「,」区切りで複数指定が可能です。
//	※ビルIDは変更になる場合があります。
//	group	string	gidを指定すると名寄せされた同一店舗をまとめて表示します。
//	※名寄せされた店舗の中でsortで指定した並び順の上位一件のみ表示されます。
//	※すべての店舗が必要な場合はdistinct=falseを指定してください。
//	distinct	boolean	group=gid時に重複レコードの表示を指定します。
//	デフォルトはtrueです。
//	名寄せされた店舗すべてが必要な場合にfalseをセットしてください。
//	※false の場合、リクエストパラメータのresultsは店舗のユニークの件数となるため、リクエストパラメータのresultsとレスポンスの<Count>の件数が異なります。
//	sort	string
//	rating（デフォルト）
//	score
//	hybrid
//	review
//	kana
//	price
//	dist
//	geo
//	match	ソートの方法を指定します:
//	ratingは、星の数順にソートします。
//	scoreは、スコア順にソートします。
//	hybridは、口コミ件数や星の数などを重み付けした値の順にソートします。
//	reviewは、口コミ件数にソートします。
//	kanaは、アイウエオ順にソートします。
//	priceは、金額順にソートします。
//	distは、2点間の直線距離順にソートします。（geoより高速です）
//	geoは、球面三角法による2点間の距離順にソートします。
//	※距離順（dist/geo）を有効にするためには、lat,lonを指定してください。
//	matchは、適合度順にソートします。
//	デフォルトは昇順で、先頭に"-"（半角マイナス）を付けることで降順になります。
//	ex) sort=-review で口コミ件数の多い順にソート
//	start	int	取得開始位置を指定します（最大3000）。
//	results	int	取得件数を指定します（最大100）。
//	detail	string
//	simple,
//	standard（デフォルト）,
//	full	出力項目数を増減できます。詳細はこちらをご覧ください。
//	output	string
//	xml（デフォルト）,
//	json
//	出力形式を指定します：
//	xml - XML形式
//	json - JSON形式
//	callback	string	JSONPとして出力する際のコールバック関数名を入力するためのパラメータ。UTF-8でエンコードした文字列を入力します。
//	lat	float	中心の緯度。
//	lon	float	中心の経度。
//	dist	float	検索距離（km）です。
//	最大20km、小数点も指定できます。
//	中心の緯度、中心の経度のパラメータが必須です。
//	bbox	string	矩形範囲の左下経度、左下緯度、右上経度、右上緯度を世界測地系十進形式で指定（コンマ区切り）。
//	ac	string	住所コード（日本工業規格（JIS） X 0401）または国コード（国際標準化機構（ISO） 3166-1 alpha-2）です。
//	住所コードは都道府県（2けた）と市町村（5けた）を指定可能です。
//	ex) 北海道:01, 札幌市中央区:01101
//	国コードは、2文字を指定してください。
//	ex) 日本:JP、アメリカ：US
//	gc	string	業種コードを指定します。YOLP業種コードをご覧ください。
//	coupon	boolean	trueを指定すると、クーポンが利用できる店舗データを対象に検索します。falseは無効です。
//	※モバイル向けサイトでは掲載不可なクーポンがあります。APIの結果をモバイル端末に掲載する場合は、リクエストパラメータ「device」をセットし「mobile」を指定してください。モバイル端末で掲載不可なクーポンが非表示になります。
//	※クーポンの利用についてはクーポン提供元サイトの利用条件（画面を印刷して提示など）に準じます。
//	parking	boolean	trueを指定すると、駐車場がある店舗データを対象に検索します。falseは無効です

	boolean parking;
	boolean creditcard = false;
	String smoking;
	boolean reservation = false;
	boolean image = false;
	String open;
	@JsonProperty("loco_mode")
	boolean locoMode = true;
	Long minprice;
	Long maxprice;
}
