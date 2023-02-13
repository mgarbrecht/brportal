package carga;

import java.sql.*;

import util.rdb.ConnectionJDBC;

public class CopiaBanco {
	private Connection conn_mysql  = null;

	
	public void carregar(String banco) throws SQLException {
	    try {
	    	conn_mysql  = ConnectionJDBC.get("loja", "root", "web80br");
	    	copia(banco);
	    } catch (Exception e){
	    	e.printStackTrace();
	    } finally {
	    	if(conn_mysql != null){
	    		conn_mysql.close();
	    	} 
	    }
	}

    private void copia(String banco) throws SQLException {

    	PreparedStatement pstm = conn_mysql.prepareStatement(
    			" DROP DATABASE "+banco);
    	try {
    		pstm.execute();
    	} catch (Exception e){
    		e.printStackTrace();
    	} finally {
    		pstm.close();
    	}

    	pstm = conn_mysql.prepareStatement(" CREATE DATABASE "+banco);
        pstm.execute();
        pstm.close();

    	pstm = conn_mysql.prepareStatement("");

    	StringBuilder sb = new StringBuilder();
    	sb.append(" CREATE TABLE `").append(banco).append("`.`address_book` ( ");
    	sb.append(" `customers_id` int( 5 ) NOT NULL default '0', ");
 		sb.append(" `address_book_id` int( 5 ) NOT NULL default '1', ");
 		sb.append(" `entry_gender` char( 1 ) NOT NULL default '', ");
 		sb.append(" `entry_company` varchar( 32 ) default NULL , ");
 		sb.append(" `entry_firstname` varchar( 32 ) NOT NULL default '', ");
 		sb.append(" `entry_lastname` varchar( 32 ) NOT NULL default '', ");
 		sb.append(" `entry_street_address` varchar( 64 ) NOT NULL default '', ");
 		sb.append(" `entry_suburb` varchar( 32 ) default NULL , ");
 		sb.append(" `entry_postcode` varchar( 10 ) NOT NULL default '', ");
 		sb.append(" `entry_city` varchar( 32 ) NOT NULL default '', ");
 		sb.append(" `entry_state` varchar( 32 ) default NULL , ");
 		sb.append(" `entry_country_id` int( 5 ) NOT NULL default '0', ");
 		sb.append(" `entry_zone_id` int( 5 ) NOT NULL default '0', ");
 		sb.append(" PRIMARY KEY ( `address_book_id` , `customers_id` ) "); 
 		sb.append(" ) TYPE = MYISAM ");    	

 		//
    	sb.append(" CREATE TABLE `").append(banco).append("`.`address_book_bkp` ( ");
    	sb.append(" `customers_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `address_book_id` int( 5 ) NOT NULL default '1', ");
    	sb.append(" `entry_gender` char( 1 ) NOT NULL default '', ");
    	sb.append(" `entry_company` varchar( 32 ) default NULL , ");
    	sb.append(" `entry_firstname` varchar( 32 ) NOT NULL default '', ");
    	sb.append(" `entry_lastname` varchar( 32 ) NOT NULL default '', ");
    	sb.append(" `entry_street_address` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `entry_suburb` varchar( 32 ) default NULL , ");
    	sb.append(" `entry_postcode` varchar( 10 ) NOT NULL default '', ");
    	sb.append(" `entry_city` varchar( 32 ) NOT NULL default '', ");
    	sb.append(" `entry_state` varchar( 32 ) default NULL , ");
    	sb.append(" `entry_country_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `entry_zone_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" PRIMARY KEY ( `address_book_id` , `customers_id` ) "); 
    	sb.append(" ) TYPE = MYISAM  ");    	

    	//
    	sb.append(" CREATE TABLE `").append(banco).append("`.`address_format` ( ");
    	sb.append(" `address_format_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `address_format` varchar( 128 ) NOT NULL default '', ");
    	sb.append(" `address_summary` varchar( 48 ) NOT NULL default '', ");
    	sb.append(" PRIMARY KEY ( `address_format_id` ) "); 
    	sb.append(" ) TYPE = MYISAM ");

    	//
    	sb.append("CREATE TABLE `"+banco+"`.`banners` ( ");
    	sb.append(" `banners_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `banners_title` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `banners_url` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `banners_image` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `banners_group` varchar( 10 ) NOT NULL default '', ");
    	sb.append(" `banners_html_text` text, ");
    	sb.append(" `expires_impressions` int( 7 ) default '0', ");
    	sb.append(" `expires_date` datetime default NULL , ");
    	sb.append(" `date_scheduled` datetime default NULL , ");
    	sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
    	sb.append(" `date_status_change` datetime default NULL , ");
    	sb.append(" `status` int( 1 ) default '1', ");	
    	sb.append(" PRIMARY KEY ( `banners_id` )  ");
    	sb.append(" ) TYPE = MYISAM ");

    	//
        sb.append(" CREATE TABLE `").append(banco).append("`.`banners_history` ( ");
        sb.append(" `banners_history_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `banners_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `banners_shown` int( 5 ) NOT NULL default '0', ");
        sb.append(" `banners_clicked` int( 5 ) NOT NULL default '0', ");
        sb.append(" `banners_history_date` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" PRIMARY KEY ( `banners_history_id` )  "); 
        sb.append(" ) TYPE = MYISAM");
    	
        //
    	sb.append("CREATE TABLE `").append(banco).append("`.`cabedal` ( ");
    	sb.append(" `cab_cdgo` int(4) NOT NULL default '0', ");
    	sb.append(" `cab_desc` varchar(60) NOT NULL default '', ");
    	sb.append("  PRIMARY KEY  (`cab_cdgo`), ");
        sb.append("  KEY `Index01` (`cab_cdgo`,`cab_desc`) ");
    	sb.append(" ) TYPE = MYISAM");    	

    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`categories` ( ");
    	sb.append(" `categories_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `categories_image` varchar( 64 ) default NULL , ");
    	sb.append(" `parent_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `sort_order` int( 3 ) default NULL , ");
    	sb.append(" `date_added` datetime default NULL , ");
    	sb.append(" `last_modified` datetime default NULL , ");
    	sb.append(" `status` int( 1 ) default '1', ");
    	sb.append(" PRIMARY KEY ( `categories_id` ) , ");
    	sb.append(" KEY `idx_categories_parent_id` ( `parent_id` )  ");
    	sb.append(" ) TYPE = MYISAM");   	
    	
    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`categories_description` ( ");
    	sb.append(" `categories_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `language_id` int( 5 ) NOT NULL default '1', ");
    	sb.append(" `categories_name` varchar( 32 ) NOT NULL default '', ");
    	sb.append(" PRIMARY KEY ( `categories_id` , `language_id` ) , ");
    	sb.append(" KEY `idx_categories_name` ( `categories_name` )  ");
    	sb.append(" ) TYPE = MYISAM");    	
    	
    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`columns_priv` ( ");
    	sb.append(" `Host` char( 60 ) NOT NULL default '', ");
    	sb.append(" `Db` char( 64 ) NOT NULL default '', ");
    	sb.append(" `User` char( 16 ) NOT NULL default '', ");
    	sb.append(" `Table_name` char( 64 ) NOT NULL default '', ");
    	sb.append(" `Column_name` char( 64 ) NOT NULL default '', ");
    	sb.append(" `Timestamp` timestamp( 14 ) NOT NULL , ");
    	sb.append(" `Column_priv` set( 'Select', 'Insert', 'Update', 'References' ) NOT NULL default '', ");
    	sb.append(" PRIMARY KEY ( `Host` , `Db` , `User` , `Table_name` , `Column_name` ) ");
    	sb.append(" ) TYPE = MYISAM MAX_ROWS =1000 PACK_KEYS =1");    	
        
    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`configuration` ( ");
    	sb.append(" `configuration_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `configuration_title` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `configuration_key` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `configuration_value` varchar( 255 ) NOT NULL default '', ");
    	sb.append(" `configuration_description` varchar( 255 ) NOT NULL default '', ");
    	sb.append(" `configuration_group_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `sort_order` int( 5 ) default NULL , ");
    	sb.append(" `last_modified` datetime default NULL , ");
    	sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
    	sb.append(" `use_function` varchar( 255 ) default NULL , ");
    	sb.append(" `set_function` varchar( 255 ) default NULL , ");
    	sb.append(" PRIMARY KEY ( `configuration_id` )  ");
    	sb.append(" ) TYPE = MYISAM");    	
        
    	//
        sb.append("CREATE TABLE `").append(banco).append("`.`configuration_group` ( ");
        sb.append(" `configuration_group_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `configuration_group_title` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `configuration_group_description` varchar( 255 ) NOT NULL default '', ");
        sb.append(" `sort_order` int( 5 ) default NULL , ");
        sb.append(" `visible` int( 1 ) default '1', ");
        sb.append(" PRIMARY KEY ( `configuration_group_id` )  ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`cor` ( ");
        sb.append(" `cor_cdgo` int( 6 ) NOT NULL default '0', ");
        sb.append(" `cor_desc` varchar( 64 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY  (`cor_cdgo`), ");
        sb.append(" KEY `Index01` (`cor_cdgo`), ");
        sb.append(" KEY `Index02` (`cor_desc`) ");
        sb.append(" ) TYPE = MYISAM");        
        
        //
    	sb.append("CREATE TABLE `").append(banco).append("`.`counter` ( ");
    	sb.append(" `startdate` char( 8 ) default NULL , ");
    	sb.append(" `counter` int( 12 ) default NULL  ");
    	sb.append(" ) TYPE = MYISAM");    	

    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`counter_history` ( ");
    	sb.append(" `month` char( 8 ) default NULL , ");
    	sb.append(" `counter` int( 12 ) default NULL "); 
    	sb.append(" ) TYPE = MYISAM ");    	

    	//
    	sb.append("CREATE TABLE `").append(banco).append("`.`countries` ( ");
    	sb.append(" `countries_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `countries_name` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `countries_iso_code_2` char( 2 ) NOT NULL default '', ");
    	sb.append(" `countries_iso_code_3` char( 3 ) NOT NULL default '', ");
    	sb.append(" `address_format_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" PRIMARY KEY ( `countries_id` ) , ");
    	sb.append(" KEY `IDX_COUNTRIES_NAME` ( `countries_name` ) "); 
    	sb.append(" ) TYPE = MYISAM ");    	

    	//
        sb.append("CREATE TABLE `").append(banco).append("`.`currencies` ( ");
        sb.append(" `currencies_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `title` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `code` char( 3 ) NOT NULL default '', ");
        sb.append(" `symbol_left` varchar( 12 ) default NULL , ");
        sb.append(" `symbol_right` varchar( 12 ) default NULL , ");
        sb.append(" `decimal_point` char( 1 ) default NULL , ");
        sb.append(" `thousands_point` char( 1 ) default NULL , ");
        sb.append(" `decimal_places` char( 1 ) default NULL , ");
        sb.append(" `value` float( 13, 8 ) default NULL , ");
        sb.append(" `last_updated` datetime default NULL , ");
        sb.append(" PRIMARY KEY ( `currencies_id` )  ");
        sb.append(" ) TYPE = MYISAM  ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`customers` ( ");
        sb.append(" `customers_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `cracha` int( 6 ) NOT NULL default '0', ");
        sb.append(" `customers_gender` char( 1 ) NOT NULL default '', ");
        sb.append(" `customers_firstname` varchar( 50 ) NOT NULL default '', ");
        sb.append(" `customers_lastname` varchar( 50 ) NOT NULL default '', ");
        sb.append(" `customers_dob` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" `customers_email_address` varchar( 96 ) NOT NULL default '', ");
        sb.append(" `customers_default_address_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `customers_telephone` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `documento_cliente` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `customers_fax` varchar( 32 ) default NULL , ");
        sb.append(" `customers_password` varchar( 40 ) NOT NULL default '', ");
        sb.append(" `customers_newsletter` char( 1 ) default NULL , ");
        sb.append(" `filial` varchar( 4 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `customers_id` ) , ");
        sb.append(" UNIQUE KEY `cracha` ( `cracha` ), ");
        sb.append(" KEY `Index01` (`customers_id`), ");
        sb.append(" KEY `Index02` (`cracha`) ");
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`customers_basket` ( ");
        sb.append(" `customers_basket_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `customers_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_id` tinytext NOT NULL , ");
        sb.append(" `customers_basket_quantity` int( 2 ) NOT NULL default '0', ");
        sb.append(" `final_price` decimal( 6, 2 ) NOT NULL default '0.00', ");
        sb.append(" `customers_basket_date_added` varchar( 8 ) default NULL , ");
        sb.append(" PRIMARY KEY ( `customers_basket_id` ),  ");
        sb.append(" KEY `Index01` (`customers_id`) ");
        sb.append(" ) TYPE = MYISAM ;");

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`customers_basket_attributes` ( ");
        sb.append(" `customers_basket_attributes_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `customers_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_id` tinytext NOT NULL , ");
        sb.append(" `products_options_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_options_value_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" PRIMARY KEY ( `customers_basket_attributes_id` ),  ");
        sb.append(" KEY `Index01` (`customers_basket_attributes_id`,`customers_id`) ");
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`customers_bkp` ( ");
        sb.append(" `customers_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `cracha` int( 6 ) NOT NULL default '0', ");
        sb.append(" `customers_gender` char( 1 ) NOT NULL default '', ");
        sb.append(" `customers_firstname` varchar( 50 ) NOT NULL default '', ");
        sb.append(" `customers_lastname` varchar( 50 ) NOT NULL default '', ");
        sb.append(" `customers_dob` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" `customers_email_address` varchar( 96 ) NOT NULL default '', ");
        sb.append(" `customers_default_address_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `customers_telephone` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `documento_cliente` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `customers_fax` varchar( 32 ) default NULL , ");
        sb.append(" `customers_password` varchar( 40 ) NOT NULL default '', ");
        sb.append(" `customers_newsletter` char( 1 ) default NULL , ");
        sb.append(" `filial` varchar( 4 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `customers_id` ), ");
        sb.append(" UNIQUE KEY `cracha` ( `cracha` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`customers_info` ( ");
        sb.append(" `customers_info_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `customers_info_date_of_last_logon` datetime default NULL , ");
        sb.append(" `customers_info_number_of_logons` int( 5 ) default NULL , ");
        sb.append(" `customers_info_date_account_created` datetime default NULL , ");
        sb.append(" `customers_info_date_account_last_modified` datetime default NULL , ");
        sb.append(" PRIMARY KEY ( `customers_info_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`db` ( ");
        sb.append(" `Host` char( 60 ) NOT NULL default '', ");
        sb.append(" `Db` char( 64 ) NOT NULL default '', ");
        sb.append(" `User` char( 16 ) NOT NULL default '', ");
        sb.append(" `Select_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Insert_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Update_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Delete_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Create_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Drop_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Grant_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `References_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Index_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Alter_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" UNIQUE KEY `Primary` ( `Host` , `Db` , `User` ) , ");
        sb.append(" KEY `User` ( `User` ) ");
        sb.append(" ) TYPE = MYISAM MAX_ROWS =1000 PACK_KEYS =1 ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`geo_zones` ( ");
        sb.append(" `geo_zone_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `geo_zone_name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `geo_zone_description` varchar( 255 ) NOT NULL default '', ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" PRIMARY KEY ( `geo_zone_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`host` ( ");
        sb.append(" `Host` char( 60 ) NOT NULL default '', ");
        sb.append(" `Db` char( 64 ) NOT NULL default '', ");
        sb.append(" `Select_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Insert_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Update_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Delete_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Create_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Drop_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Grant_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `References_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Index_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Alter_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" UNIQUE KEY `Primary` ( `Host` , `Db` ) ");
        sb.append(" ) TYPE = MYISAM MAX_ROWS =100 PACK_KEYS =1 ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`itens_comprados_filial` ( ");
        sb.append(" `filial` char( 4 ) NOT NULL default '', ");
        sb.append(" `products_model` char( 12 ) default NULL , ");
        sb.append(" `products_name` char( 64 ) NOT NULL default '', ");
        sb.append(" `products_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `cab_cdgo` int( 4 ) NOT NULL default '0', ");
        sb.append(" `cab_desc` char( 60 ) NOT NULL default '', ");
        sb.append(" `cor_cdgo` int( 6 ) NOT NULL default '0', ");
        sb.append(" `cor_desc` char( 64 ) NOT NULL default '', ");
        sb.append(" `orders_status` char( 10 ) NOT NULL default '', ");
        sb.append(" `date_purchased` datetime default NULL , ");
        sb.append(" `tai_codigo` char( 32 ) NOT NULL default '', ");
        sb.append(" `products_quantity` double( 17, 0 ) default NULL "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`languages` ( ");
        sb.append(" `languages_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `code` char( 2 ) NOT NULL default '', ");
        sb.append(" `image` varchar( 64 ) default NULL , ");
        sb.append(" `directory` varchar( 32 ) default NULL , ");
        sb.append(" `sort_order` int( 3 ) default NULL , ");
        sb.append(" PRIMARY KEY ( `languages_id` ) , ");
        sb.append(" KEY `IDX_LANGUAGES_NAME` ( `name` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`manufacturers` ( ");
        sb.append(" `manufacturers_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `manufacturers_name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `manufacturers_image` varchar( 64 ) default NULL , ");
        sb.append(" `date_added` datetime default NULL , ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" PRIMARY KEY ( `manufacturers_id` ) , ");
        sb.append(" KEY `IDX_MANUFACTURERS_NAME` ( `manufacturers_name` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`manufacturers_info` ( ");
        sb.append(" `manufacturers_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `languages_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `manufacturers_url` varchar( 255 ) NOT NULL default '', ");
        sb.append(" `url_clicked` int( 5 ) NOT NULL default '0', ");
        sb.append(" `date_last_click` datetime default NULL , ");
        sb.append(" PRIMARY KEY ( `manufacturers_id` , `languages_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`orders` ( ");
        sb.append(" `orders_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `customers_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `customers_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `customers_street_address` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `customers_suburb` varchar( 32 ) default NULL , ");
        sb.append(" `customers_city` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `customers_postcode` varchar( 10 ) NOT NULL default '', ");
        sb.append(" `customers_state` varchar( 32 ) default NULL , ");
        sb.append(" `customers_country` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `customers_telephone` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `customers_email_address` varchar( 96 ) NOT NULL default '', ");
        sb.append(" `documento_cliente` varchar( 32 ) default NULL , ");
        sb.append(" `customers_address_format_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `delivery_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `delivery_street_address` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `delivery_suburb` varchar( 32 ) default NULL , ");
        sb.append(" `delivery_city` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `delivery_postcode` varchar( 10 ) NOT NULL default '', ");
        sb.append(" `delivery_state` varchar( 32 ) default NULL , ");
        sb.append(" `delivery_country` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `delivery_address_format_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `payment_method` varchar( 12 ) NOT NULL default '', ");
        sb.append(" `numero_boleto` varchar( 20 ) default NULL , ");
        sb.append(" `cc_type` varchar( 20 ) default NULL , ");
        sb.append(" `cc_owner` varchar( 64 ) default NULL , ");
        sb.append(" `cc_number` varchar( 32 ) default NULL , ");
        sb.append(" `cc_expires` varchar( 4 ) default NULL , ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" `date_purchased` datetime default NULL , ");
        sb.append(" `shipping_cost` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `shipping_method` varchar( 32 ) default NULL , ");
        sb.append(" `orders_status` varchar( 10 ) NOT NULL default '', ");
        sb.append(" `orders_date_finished` datetime default NULL , ");
        sb.append(" `comments` text, ");
        sb.append(" `currency` char( 3 ) default NULL , ");
        sb.append(" `currency_value` decimal( 14, 6 ) default NULL , ");
        sb.append(" PRIMARY KEY ( `orders_id` ), "); 
        sb.append(" KEY `Index01` (`orders_id`), ");
        sb.append(" KEY `Index02` (`date_purchased`), ");
        sb.append(" KEY `Index03` (`orders_status`) ");        
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`orders_products` ( ");
        sb.append(" `orders_products_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `orders_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_model` varchar( 12 ) default NULL , ");
        sb.append(" `products_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `products_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `final_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `products_tax` decimal( 7, 4 ) NOT NULL default '0.0000', ");
        sb.append(" `products_quantity` int( 2 ) NOT NULL default '0', ");
        sb.append(" PRIMARY KEY ( `orders_products_id` ),  ");
        sb.append(" KEY `Index01` (`orders_products_id`,`orders_id`,`products_id`) ");
        sb.append(" ) TYPE = MYISAM ;");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`orders_products_attributes` ( ");
        sb.append(" `orders_products_attributes_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `orders_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `orders_products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_options` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `products_options_values` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `options_values_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `price_prefix` char( 1 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `orders_products_attributes_id` ),  ");
        sb.append(" KEY `Index01` (`products_options`), ");
        sb.append(" KEY `Index02` (`orders_id`,`orders_products_id`) ");        
        sb.append(") TYPE = MYISAM");

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`orders_status` ( ");
        sb.append(" `orders_status_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `language_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `orders_status_name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `orders_status_id` , `language_id` ) , ");
        sb.append(" KEY `idx_orders_status_name` ( `orders_status_name` ),  ");
        sb.append(" KEY `Index01` (`orders_status_id`,`language_id`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products` ( ");
        sb.append(" `products_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `products_quantity` int( 4 ) NOT NULL default '0', ");
        sb.append(" `products_model` varchar( 12 ) NOT NULL default '', ");
        sb.append(" `products_image` varchar( 64 ) default NULL , ");
        sb.append(" `products_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `products_date_added` datetime default NULL , ");
        sb.append(" `products_last_modified` datetime default NULL , ");
        sb.append(" `products_date_available` datetime default NULL , ");
        sb.append(" `products_weight` decimal( 5, 2 ) NOT NULL default '0.00', ");
        sb.append(" `products_status` tinyint( 1 ) NOT NULL default '0', ");
        sb.append(" `products_tax_class_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `manufacturers_id` int( 5 ) default NULL , ");
        sb.append(" PRIMARY KEY ( `products_id` ), ");
        sb.append(" KEY `Index01` (`products_model`), ");
        sb.append(" KEY `Index02` (`products_id`) ");        
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_attributes` ( ");
        sb.append(" `products_attributes_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `options_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `options_values_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `options_values_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `price_prefix` char( 1 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `products_attributes_id` ), ");
        sb.append(" KEY `Index01` (`products_attributes_id`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_description` ( ");
        sb.append(" `products_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `language_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `products_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `products_description` text, ");
        sb.append(" `products_url` varchar( 255 ) default NULL , ");
        sb.append(" `products_viewed` int( 5 ) default '0', ");
        sb.append(" PRIMARY KEY ( `products_id` , `language_id` ), ");
        sb.append(" KEY `products_name` ( `products_name` )  ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_estoque` ( ");
        sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `cab_cdgo` int( 6 ) NOT NULL default '0', ");
        sb.append(" `cor_cdgo` int( 6 ) NOT NULL default '0', ");
        sb.append(" `gra_cdgo` int( 6 ) NOT NULL default '0', ");
        sb.append(" `estoque_atual` int( 8 ) NOT NULL default '0', ");
        sb.append(" `estoque_lanc` int( 8 ) NOT NULL default '0', ");
        sb.append(" PRIMARY KEY  (`products_id`,`cab_cdgo`,`cor_cdgo`,`gra_cdgo`), ");
        sb.append(" KEY `Index01` (`products_id`,`cab_cdgo`,`cor_cdgo`,`gra_cdgo`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_options` ( ");
        sb.append(" `products_options_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `language_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `products_options_name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `products_options_id` , `language_id` ),  ");
        sb.append(" KEY `Index01` (`products_options_id`,`language_id`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_options_values` ( ");
        sb.append(" `products_options_values_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `language_id` int( 5 ) NOT NULL default '1', ");
        sb.append(" `products_options_values_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `products_options_values_id` , `language_id` ),  ");
        sb.append(" KEY `Index01` (`products_options_values_name`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_options_values_to_products_options` ( ");
        sb.append(" `products_options_values_to_products_options_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `products_options_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `products_options_values_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" PRIMARY KEY ( `products_options_values_to_products_options_id` ) "); 
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`products_to_categories` ( ");
        sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `categories_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" PRIMARY KEY ( `products_id` , `categories_id` ),  ");
        sb.append(" KEY `Index01` (`products_id`,`categories_id`) ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`ref_cor` ( ");
        sb.append(" `modelo` varchar( 12 ) default NULL , ");
        sb.append(" `cab_cdgo` decimal( 4, 0 ) default NULL , ");
        sb.append(" `cor_cdgo` decimal( 6, 0 ) default NULL , ");
        sb.append(" KEY `idx_modelo` ( `modelo` ),  ");
        sb.append(" KEY `Index01` (`cab_cdgo`), ");
        sb.append(" KEY `Index02` (`cor_cdgo`) ");
        sb.append(") TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`reviews` ( ");
    	sb.append(" `reviews_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
    	sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
    	sb.append(" `customers_id` int( 5 ) default NULL , ");
    	sb.append(" `customers_name` varchar( 64 ) NOT NULL default '', ");
    	sb.append(" `reviews_rating` int( 1 ) default NULL , ");
    	sb.append(" `date_added` datetime default NULL , ");
    	sb.append(" `last_modified` datetime default NULL , ");
    	sb.append(" `reviews_read` int( 5 ) NOT NULL default '0', ");
    	sb.append(" PRIMARY KEY ( `reviews_id` )  ");
    	sb.append(" ) TYPE = MYISAM");        

    	//
        sb.append("CREATE TABLE `").append(banco).append("`.`reviews_description` ( ");
        sb.append(" `reviews_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `languages_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `reviews_text` text NOT NULL , ");
        sb.append(" PRIMARY KEY ( `reviews_id` , `languages_id` )  ");
        sb.append(" ) TYPE = MYISAM");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`sessions` ( ");
        sb.append(" `sesskey` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `expiry` int( 11 ) unsigned NOT NULL default '0', ");
        sb.append(" `value` text NOT NULL , ");
        sb.append(" PRIMARY KEY ( `sesskey` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`specials` ( ");
        sb.append(" `specials_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `products_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `specials_new_products_price` decimal( 8, 2 ) NOT NULL default '0.00', ");
        sb.append(" `specials_date_added` datetime default NULL , ");
        sb.append(" `specials_last_modified` datetime default NULL , ");
        sb.append(" `expires_date` datetime default NULL , ");
        sb.append(" `date_status_change` datetime default NULL , ");
        sb.append(" `status` int( 1 ) default '1', ");
        sb.append(" PRIMARY KEY ( `specials_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`tables_priv` ( ");
        sb.append(" `Host` char( 60 ) NOT NULL default '', ");
        sb.append(" `Db` char( 64 ) NOT NULL default '', ");
        sb.append(" `User` char( 16 ) NOT NULL default '', ");
        sb.append(" `Table_name` char( 64 ) NOT NULL default '', ");
        sb.append(" `Grantor` char( 77 ) NOT NULL default '', ");
        sb.append(" `Timestamp` timestamp( 14 ) NOT NULL , ");
        sb.append(" `Table_priv` set( 'Select', 'Insert', 'Update', 'Delete', 'Create', 'Drop', 'Grant', 'References', 'Index', 'Alter' ) NOT NULL default '', ");
        sb.append(" `Column_priv` set( 'Select', 'Insert', 'Update', 'References' ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `Host` , `Db` , `User` , `Table_name` ) ");
        sb.append(" ) TYPE = MYISAM MAX_ROWS =1000 PACK_KEYS =1 ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`tax_class` ( ");
        sb.append(" `tax_class_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `tax_class_title` varchar( 32 ) NOT NULL default '', ");
        sb.append(" `tax_class_description` varchar( 255 ) NOT NULL default '', ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" PRIMARY KEY ( `tax_class_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`tax_rates` ( ");
        sb.append(" `tax_rates_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `tax_zone_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `tax_class_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `tax_priority` int( 5 ) default '1', ");
        sb.append(" `tax_rate` decimal( 7, 4 ) NOT NULL default '0.0000', ");
        sb.append(" `tax_description` varchar( 255 ) NOT NULL default '', ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" PRIMARY KEY ( `tax_rates_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`user` ( ");
        sb.append(" `Host` char( 60 ) NOT NULL default '', ");
        sb.append(" `User` char( 16 ) NOT NULL default '', ");
        sb.append(" `Password` char( 16 ) NOT NULL default '', ");
        sb.append(" `Select_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Insert_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Update_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Delete_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Create_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Drop_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Reload_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Shutdown_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Process_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `File_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Grant_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `References_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Index_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" `Alter_priv` enum( 'N', 'Y' ) NOT NULL default 'N', ");
        sb.append(" UNIQUE KEY `Primary` ( `Host` , `User` ) ");
        sb.append(" ) TYPE = MYISAM MAX_ROWS =1000 PACK_KEYS =1 ");        
 
        //
        sb.append("CREATE TABLE `").append(banco).append("`.`vendas_semana` ( ");
        sb.append(" `products_id` mediumint( 6 ) NOT NULL default '0', ");
        sb.append(" `cab_cdgo` varchar( 8 ) NOT NULL default '0', ");
        sb.append(" `cor_cdgo` varchar( 8 ) NOT NULL default '0', ");
        sb.append(" `tam_cdgo` varchar( 8 ) NOT NULL default '', ");
        sb.append(" `qtde_atual` int( 12 ) NOT NULL default '0', ");
        sb.append(" `filial` varchar( 4 ) NOT NULL default '', ");
        sb.append(" `customers_id` int( 5 ) NOT NULL default '0' ");
        sb.append(" ) TYPE = MYISAM ");        
   
        //
        sb.append("CREATE TABLE `").append(banco).append("`.`whos_online` ( ");
        sb.append(" `customer_id` int( 5 ) default NULL , ");
        sb.append(" `full_name` varchar( 64 ) NOT NULL default '', ");
        sb.append(" `session_id` varchar( 128 ) NOT NULL default '', ");
        sb.append(" `ip_address` varchar( 15 ) NOT NULL default '', ");
        sb.append(" `time_entry` varchar( 14 ) NOT NULL default '', ");
        sb.append(" `time_last_click` varchar( 14 ) NOT NULL default '', ");
        sb.append(" `last_page_url` varchar( 64 ) NOT NULL default '' ");
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`zones` ( ");
        sb.append(" `zone_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `zone_country_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `zone_code` varchar( 5 ) NOT NULL default '', ");
        sb.append(" `zone_name` varchar( 32 ) NOT NULL default '', ");
        sb.append(" PRIMARY KEY ( `zone_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`zones_to_geo_zones` ( ");
        sb.append(" `association_id` int( 5 ) NOT NULL AUTO_INCREMENT , ");
        sb.append(" `zone_country_id` int( 5 ) NOT NULL default '0', ");
        sb.append(" `zone_id` int( 5 ) default NULL , ");
        sb.append(" `geo_zone_id` int( 5 ) default NULL , ");
        sb.append(" `last_modified` datetime default NULL , ");
        sb.append(" `date_added` datetime NOT NULL default '0000-00-00 00:00:00', ");
        sb.append(" PRIMARY KEY ( `association_id` ) "); 
        sb.append(" ) TYPE = MYISAM ");        

        //
        sb.append("CREATE TABLE `").append(banco).append("`.`usuarios` ( ");
        sb.append(" `id` int(22) NOT NULL default '0', ");
        sb.append(" `nome` varchar(80) NOT NULL default '', ");
        sb.append(" `senha` varchar(40) NOT NULL default '', ");
        sb.append(" `super` char(1) NOT NULL default 'N', ");
        sb.append(" `bloqueio_loja` char(1) NOT NULL default 'N', ");        
        sb.append(" PRIMARY KEY  (`id`), ");
        sb.append(" KEY `Index01` (`id`) ");
        sb.append(" ) TYPE=MyISAM ");
        pstm.addBatch(sb.toString());

        
        pstm.addBatch("INSERT INTO `"+banco+"`.`address_book` SELECT * FROM `loja`.`address_book` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`address_book_bkp` SELECT * FROM `loja`.`address_book_bkp` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`address_format` SELECT * FROM `loja`.`address_format` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`banners` SELECT * FROM `loja`.`banners` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`banners_history` SELECT * FROM `loja`.`banners_history` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`cabedal` SELECT * FROM `loja`.`cabedal` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`categories` SELECT * FROM `loja`.`categories` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`categories_description` SELECT * FROM `loja`.`categories_description` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`columns_priv` SELECT * FROM `loja`.`columns_priv` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`configuration` SELECT * FROM `loja`.`configuration` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`configuration_group` SELECT * FROM `loja`.`configuration_group` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`cor` SELECT * FROM `loja`.`cor` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`counter` SELECT * FROM `loja`.`counter` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`counter_history` SELECT * FROM `loja`.`counter_history` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`countries` SELECT * FROM `loja`.`countries` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`currencies` SELECT * FROM `loja`.`currencies` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`customers` SELECT * FROM `loja`.`customers` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`customers_basket` SELECT * FROM `loja`.`customers_basket` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`customers_basket_attributes` SELECT * FROM `loja`.`customers_basket_attributes` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`customers_bkp` SELECT * FROM `loja`.`customers_bkp` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`customers_info` SELECT * FROM `loja`.`customers_info` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`db` SELECT * FROM `loja`.`db` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`geo_zones` SELECT * FROM `loja`.`geo_zones` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`host` SELECT * FROM `loja`.`host` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`itens_comprados_filial` SELECT * FROM `loja`.`itens_comprados_filial` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`languages` SELECT * FROM `loja`.`languages` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`manufacturers` SELECT * FROM `loja`.`manufacturers` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`manufacturers_info` SELECT * FROM `loja`.`manufacturers_info` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`orders` SELECT * FROM `loja`.`orders` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`orders_products` SELECT * FROM `loja`.`orders_products` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`orders_products_attributes` SELECT * FROM `loja`.`orders_products_attributes` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`orders_status` SELECT * FROM `loja`.`orders_status` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products` SELECT * FROM `loja`.`products` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_attributes` SELECT * FROM `loja`.`products_attributes` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_description` SELECT * FROM `loja`.`products_description` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_estoque`  SELECT * FROM `loja`.`products_estoque` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_options` SELECT * FROM `loja`.`products_options` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_options_values` SELECT * FROM `loja`.`products_options_values` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_options_values_to_products_options` SELECT * FROM `loja`.`products_options_values_to_products_options` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`products_to_categories` SELECT * FROM `loja`.`products_to_categories` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`ref_cor` SELECT * FROM `loja`.`ref_cor` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`reviews` SELECT * FROM `loja`.`reviews` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`reviews_description` SELECT * FROM `loja`.`reviews_description` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`sessions` SELECT * FROM `loja`.`sessions` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`specials` SELECT * FROM `loja`.`specials` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`tables_priv` SELECT * FROM `loja`.`tables_priv` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`tax_class` SELECT * FROM `loja`.`tax_class` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`tax_rates` SELECT * FROM `loja`.`tax_rates` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`user` SELECT * FROM `loja`.`user` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`vendas_semana` SELECT * FROM `loja`.`vendas_semana` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`whos_online` SELECT * FROM `loja`.`whos_online` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`zones` SELECT * FROM `loja`.`zones` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`zones_to_geo_zones` SELECT * FROM `loja`.`zones_to_geo_zones` ");
        pstm.addBatch("INSERT INTO `"+banco+"`.`usuarios` SELECT * FROM `loja`.`usuarios` ");
        pstm.executeBatch();
        pstm.close();
    }
}