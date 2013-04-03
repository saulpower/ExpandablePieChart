
package com.saulpower.piechart.extra;

import com.saulpower.piechart.R;

public class Constant {
    
    /*******************************************************************
     * INTENT
     *******************************************************************/

    public static final String EXTRA_ACCOUNT_ID = "account_id";
    public static final String EXTRA_ID = "bod_id";
    public static final String EXTRA_CATEGORY_ID = "category_id";
    public static final String EXTRA_FRAGMENT = "fragment";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_POSITION_X = "position_x";
    public static final String EXTRA_POSITION_Y = "position_y";
    public static final String EXTRA_SOURCE_CODE = "source_code";
    public static final String EXTRA_TXN_TYPE = "txn_type";
    public static final String EXTRA_VALUES = "values";
    
    public static final int CODE_CATEGORY_LIST = 1;
    public static final int CODE_CATEGORY_DETAIL = 2;
    public static final int CODE_TAG_DETAIL = 3;
    
	/*******************************************************************
	 * FLAGS
	 *******************************************************************/
	
	public static final int FLAG_BANK_USER_CREATED = 1 << 8;


    /*******************************************************************
     * KEYS
     *******************************************************************/

    public static final String KEY_ACCOUNTS = "accounts";
    public static final String KEY_ACCOUNT_GUID = "account_guid";
    public static final String KEY_ACCOUNT_TYPE = "account_type";
    public static final String KEY_ACCOUNTTYPE = "accountType";
    public static final String KEY_ACCOUNT_NAME = "account_name";
    public static final String KEY_ACCOUNT_TYPE_ID = "account_id";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_ASSOCIATION_DESTROYED = "_association_destroyed";
    public static final String KEY_BANK_ACCOUNT_ID = "bank_account_id";
    public static final String KEY_BUDGETS = "budgets";
    public static final String KEY_CATEGORIES = "categories";
    public static final String KEY_CATEGORY_GUID = "category_guid";
    public static final String KEY_CLASSID = "classID";
    public static final String KEY_CREATED = "created";
    public static final String KEY_CREDENTIALS = "credentials";
    public static final String KEY_CREDIT_LIMIT = "credit_limit";
    public static final String KEY_CUSTOM_FIELDS = "custom_fields";
    public static final String KEY_BALANCE = "balance";
    public static final String KEY_DATE = "date";
    public static final String KEY_DAY_DUE = "day_due";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_DELETED = "deleted";
    public static final String KEY_DEVICE = "device";
    public static final String KEY_DUPLICATE = "duplicate";
    public static final String KEY_EXTERNAL_ID = "external_id";
    public static final String KEY_FLAGS = "flags";
    public static final String KEY_FULL_SYNC = "full_sync_required";
    public static final String KEY_GUID = "guid";
    public static final String KEY_HAS_BEEN_VIEWED = "has_been_viewed";
    public static final String KEY_HAS_PREVIOUS = "has_previous";
    public static final String KEY_ID = "id";
    public static final String KEY_INCOME = "income";
    public static final String KEY_INSTITUTION = "institution";
    public static final String KEY_INSTITUTION_GUID = "institution_guid";
    public static final String KEY_INSTITUTION_NAME = "institution_name";
    public static final String KEY_INSTRUCTIONS = "instructions";
    public static final String KEY_INTEREST_RATE = "interest_rate";
    public static final String KEY_ISDELETED = "isDeleted";
    public static final String KEY_IS_CLEARED = "is_cleared";
    public static final String KEY_IS_DELETED = "is_deleted";
    public static final String KEY_IS_FLAGGED = "is_flagged";
    public static final String KEY_IS_HIDDEN = "is_hidden";
    public static final String KEY_IS_HOLDING = "is_holding";
    public static final String KEY_IS_MANUAL = "is_manual";
    public static final String KEY_IS_PERSONAL = "is_personal";
    public static final String KEY_IS_REIMBURSABLE = "is_reimbursable";
    public static final String KEY_IS_VOID = "is_void";
    public static final String KEY_JSON = "json";
    public static final String KEY_LABEL = "label";
    public static final String KEY_LAST_JOB = "last_job_status";
    public static final String KEY_LAST_UPDATE = "last_update_time";
    public static final String KEY_LOGIN_TOKEN = "login_token";
    public static final String KEY_MEMBER = "member";
    public static final String KEY_MEMBERS = "members";
    public static final String KEY_MEMBER_GUID = "member_guid";
    public static final String KEY_MEMO = "memo";
    public static final String KEY_MFA = "mfa";
    public static final String KEY_MIN_PAYMENT = "minimum_payment";
    public static final String KEY_NAME = "name";
    public static final String KEY_OBJECTS = "objects";
    public static final String KEY_ORG_BALANCE = "original_balance";
    public static final String KEY_PARENT_GUID = "parent_guid";
    public static final String KEY_POPULARITY = "popularity";
    public static final String KEY_POSTED_DATE = "posted_date";
    public static final String KEY_PROCESS_STATUS = "process_status";
    public static final String KEY_PROPERTY_TYPE = "property_type";
    public static final String KEY_RECORDS = "records";
    public static final String KEY_REFERENCE = "reference";
    public static final String KEY_REVISION = "revision";
    public static final String KEY_STATUS = "status";
    public static final String KEY_STATUS_CODE = "status_code";
    public static final String KEY_SYNC_TOKEN = "sync_token";
    public static final String KEY_TAGS = "tags";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TRANSACTIONS = "transactions";
    public static final String KEY_TRANSACTION_TYPE = "transaction_type";
    public static final String KEY_UPDATED = "updated";
    public static final String KEY_URL = "url";
    public static final String KEY_USER_CREATED = "user_created";
    public static final String KEY_USER_DATE = "user_date";
    public static final String KEY_USER_DESCRIPTION = "user_description";
    public static final String KEY_USER_GUID = "user_guid";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_USER_NAME = "user_name";

    /*******************************************************************
     * MISC
     *******************************************************************/

    public static final String BUSINESS = "business";
    public static final String BUSINESS_OBJECT = "business_object";
    public static final String INCOME = "income";
    public static final String PERSONAL = "personal";
    public static final String UNCATEGORIZED = "uncategorized";
    public static final int QUERY_LIMIT = 30;
    public static final float STANDARD_DPI = 160f;
    public static final float LARGE_TABLET_SCALE = 1.43f;
    public static final float XHDPI_SCALE = 0.75f;

	/*******************************************************************
	 * QUERIES
	 *******************************************************************/
    
    public static final String ORDER_ASC = "ASC";
    public static final String ORDER_DESC = "DESC";
    
    public static final String FIELD_DATE = "T.DATE";
    public static final String FIELD_TITLE = "T.TITLE";
    public static final String FIELD_CATEGORY = "C.CATEGORY_NAME";
    public static final String FIELD_AMOUNT = "T.AMOUNT";
	
    public static final String QUERY_SUMMED_TRANSACTIONS = "SELECT DATE, sum(RAW_AMOUNT) FROM TRANSACTIONS WHERE BANK_ACCOUNT_ID = ? GROUP BY DATE ORDER BY DATE ASC";
    public static final String QUERY_BOB_ID = "SELECT MAX(_ID) FROM BUSINESS_OBJECT_BASE";
    public static final String QUERY_BUSINESS_BASE_JOIN = ", BUSINESS_OBJECT_BASE B WHERE T.BUSINESS_OBJECT_ID = B._ID AND B.DATA_STATE = ?";
    public static final String QUERY_TRANSACTIONS = " ORDER BY %s %s LIMIT ? OFFSET ?";
    public static final String QUERY_DATE_TRANSACTIONS = ", CATEGORY C WHERE T.CATEGORY_ID = C._ID AND ("
            + FIELD_TITLE
            + " LIKE ? OR "
            + FIELD_CATEGORY
            + " LIKE ?) AND "
            + FIELD_DATE
            + " BETWEEN ? AND ? ORDER BY %s %s LIMIT ? OFFSET ?";
    public static final String QUERY_TOP_SPENDING_CATEGORY = "SELECT CATEGORY_ID, Sum(AMOUNT) As AMOUNT FROM TRANSACTIONS WHERE DATE BETWEEN ? AND ? GROUP BY CATEGORY_ID ORDER BY AMOUNT desc ";
    public static final String QUERY_DATED_TRANSACTIONS = "SELECT * FROM TRANSACTIONS WHERE DATE BETWEEN ? AND ? ORDER BY DATE ASC";
    public static final String QUERY_UNVIEWED_TRANSACTIONS = "SELECT COUNT(IS_PROCESSED) As UnProcessedTrans FROM TRANSACTIONS WHERE IS_PROCESSED='0' AND DATE BETWEEN ? AND ? ";
    public static final String QUERY_DAILY_TRANSACTIONS = "SELECT DATE, SUM(AMOUNT) AS Amount FROM TRANSACTIONS WHERE %s AND DATE BETWEEN ? AND ? GROUP BY YEAR_NUMBER, MONTH_NUMBER, DAY_NUMBER ORDER BY DATE ASC";
    public static final String QUERY_MONTHLY_TRANSACTIONS = "SELECT DATE, SUM(AMOUNT) AS Amount FROM TRANSACTIONS WHERE %s AND DATE BETWEEN ? AND ? GROUP BY YEAR_NUMBER, MONTH_NUMBER ORDER BY DATE ASC";
    public static final String QUERY_QUARTERLY_TRANSACTIONS = "SELECT DATE, SUM(AMOUNT) AS Amount, QUARTER_NUMBER FROM TRANSACTIONS WHERE %s AND DATE BETWEEN ? AND ? GROUP BY YEAR_NUMBER, QUARTER_NUMBER ORDER BY DATE ASC";
    public static final String QUERY_YEARLY_TRANSACTIONS = "SELECT DATE, SUM(AMOUNT) AS Amount FROM TRANSACTIONS WHERE %s AND DATE BETWEEN ? AND ? GROUP BY YEAR_NUMBER ORDER BY DATE ASC";
    /*******************************************************************
     * VALUES
     *******************************************************************/

    public static final String VALUE_NULL = "null";

    /*******************************************************************
     * ARRAYS & MAPS
     *******************************************************************/
    
	public static int[] RANDOM_COLORS = new int[] {
	        R.color.random1,
	        R.color.random2,
	        R.color.random3,
	        R.color.random4,
	        R.color.random5,
	        R.color.random6,
	        R.color.random7,
	        R.color.random8,
	        R.color.random9,
	        R.color.random10,
	        R.color.random11,
	        R.color.random12,
	        R.color.random13,
	        R.color.random14,
	        R.color.random15,
	        R.color.random16
    };
}
