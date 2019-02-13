 DROP TABLE IF EXISTS Points_account;
CREATE TABLE Points_account
(
POINTS_ACCOUNT_ID           INT  AUTO_INCREMENT         NOT NULL        ,
PROGRAM_ID                  INT           NOT NULL        ,
MEMBERSHIP_ID               INT                           ,
ACCOUNT_START_DTTM          DATETIME                      ,
CREATED_BY_ID               VARCHAR(100)    NOT NULL      ,
CREATED_DTTM                DATETIME             NOT NULL ,
LAST_UPDATED_BY_ID      VARCHAR(100)    NOT NULL      ,
LAST_UPDATED_DTTM       DATETIME             NOT NULL ,
STATUS_ID                   INT           NOT NULL        ,
PARTNER_MEMBERSHIP_ID       VARCHAR(30)                   ,
PARTNER_COMPANY_ID          INT                           ,
POINTS_ACCOUNT_TYPE_CD      VARCHAR(10)     NOT NULL       ,
primary key(POINTS_ACCOUNT_ID)
)engine=innodb;

DROP TABLE IF EXISTS POINTS_ACCOUNT_TYPE;
CREATE TABLE POINTS_ACCOUNT_TYPE
(
POINTS_ACCOUNT_TYPE_CD    VARCHAR(10)             NOT NULL ,
POINTS_ACCOUNT_TYPE_DESC  VARCHAR(100)            NOT NULL ,
CREATED_BY_ID             VARCHAR(100)            NOT NULL ,
CREATED_DTTM              DATETIME                     NOT NULL ,
LAST_UPDATED_BY_ID    VARCHAR(100)            NOT NULL ,
LAST_UPDATED_DTTM     DATETIME                     NOT NULL ,
primary key(POINTS_ACCOUNT_TYPE_CD)
)engine=innodb;

DROP TABLE IF EXISTS PROGRAM;
CREATE TABLE PROGRAM
(
PROGRAM_ID                   INT     AUTO_INCREMENT     NOT NULL ,
PROGRAM_CD                   VARCHAR(10)    NOT NULL             ,
PROGRAM_NAME                 VARCHAR(100)   NOT NULL             ,
CREATED_BY_ID                VARCHAR(100)   NOT NULL             ,
CREATED_DTTM                 DATETIME            NOT NULL        ,
LAST_UPDATED_BY_ID           VARCHAR(100)   NOT NULL         ,
LAST_UPDATED_DTTM            DATETIME            NOT NULL    ,
primary key(PROGRAM_ID)
)engine=innodb;

DROP TABLE IF EXISTS STATUS;
CREATE TABLE STATUS                                               
(                                                                
STATUS_ID              INT   AUTO_INCREMENT       NOT NULL       ,
STATUS_CD              VARCHAR(10)    NOT NULL                   ,
STATUS_CAT_NAME        VARCHAR(100)   NOT NULL                   ,
STATUS_DEFINITION_DESC VARCHAR(250)                              ,
ACTIVE_IND             INT(1)                                    ,
CREATED_BY_ID          VARCHAR(100)   NOT NULL                   ,
CREATED_DTTM           DATETIME            NOT NULL              ,
LAST_UPDATED_BY_ID     VARCHAR(100)   NOT NULL                   ,
LAST_UPDATED_DTTM      DATETIME            NOT NULL              ,
primary key(STATUS_ID)
)engine=innodb;

DROP TABLE IF EXISTS POINTS_DEPOSIT_TRANS_DETAIL;
CREATE TABLE POINTS_DEPOSIT_TRANS_DETAIL
(
POINTS_DEPOSIT_TRANS_DETAIL_ID INT AUTO_INCREMENT          NOT NULL     ,
REFERENCE_POINTS_DEPOSIT_ID    INT                                      ,
POINTS_ACCOUNT_ID              INT           NOT NULL                   ,
POINTS_TRANS_HEADER_ID         INT           NOT NULL                   ,
POINTS_TYPE_CD                 VARCHAR(10)     NOT NULL                 ,
TRANS_TYPE_ID                  INT           NOT NULL                   ,
EFFECTIVE_START_DTTM           DATETIME             NOT NULL            ,
EFFECTIVE_END_DTTM             DATETIME             NOT NULL            ,
TRANSACTION_ID                     INT                                  ,
POINTS_DEPOSIT_TRANS_QTY       decimal(18,4)                                ,
VERIFICATION_IND               INT(1)        NOT NULL                   ,
CREATED_BY_ID                  VARCHAR(100)    NOT NULL                 ,
CREATED_DTTM                   DATETIME             NOT NULL            ,
LAST_UPDATED_BY_ID             VARCHAR(100)    NOT NULL             ,
LAST_UPDATED_DTTM              DATETIME             NOT NULL        ,
POINTS_SPEND_TRANS_DETAIL_ID   INT                                      ,
primary key(POINTS_DEPOSIT_TRANS_DETAIL_ID)
)engine=innodb;



DROP TABLE IF EXISTS TRANS_TYPE;
CREATE TABLE TRANS_TYPE
(
TRANS_TYPE_ID      INT     AUTO_INCREMENT      NOT NULL   ,
TRANS_TYPE_CD      VARCHAR(10)     NOT NULL               ,
TRANS_TYPE_DESC    VARCHAR(100)                           ,
CAT_CD             VARCHAR(10)     NOT NULL               ,
LAST_UPDATED_BY_ID VARCHAR(100)    NOT NULL               ,
LAST_UPDATED_DTTM  DATETIME             NOT NULL          ,
ACTIVE_IND         INT(1)        NOT NULL                 ,
CREATED_BY_ID      VARCHAR(100)    NOT NULL               ,
CREATED_DTTM       DATETIME             NOT NULL          ,                          
primary key(TRANS_TYPE_ID)
)engine=innodb;

DROP TABLE IF EXISTS POINTS_TRANS_HEADER;
CREATE TABLE POINTS_TRANS_HEADER
(
POINTS_TRANS_HEADER_ID     INT  AUTO_INCREMENT         NOT NULL   ,
BATCH_HEADER_ID            INT                                    ,
MEMBERSHIP_ID              INT                                    ,
COMPANY_ID                 INT                                    ,
CHANNEL_CD                 VARCHAR(10)                            ,
CREATED_BY_ID              VARCHAR(100)    NOT NULL               ,
CREATED_DTTM               DATETIME             NOT NULL          ,
LAST_UPDATED_DTTM          DATETIME             NOT NULL      ,
LAST_UPDATED_BY_ID         VARCHAR(100)    NOT NULL           ,               
primary key(POINTS_TRANS_HEADER_ID)
)engine=innodb;



DROP TABLE IF EXISTS POINTS_SPEND_TRANS_DETAIL;
CREATE TABLE POINTS_SPEND_TRANS_DETAIL
(
POINTS_SPEND_TRANS_DETAIL_ID    INT  AUTO_INCREMENT        NOT NULL              ,
POINTS_DEPOSIT_TRANS_DETAIL_ID  INT          NOT NULL              ,
POINTS_TRANS_HEADER_ID          INT          NOT NULL              ,
TRANS_TYPE_ID                   INT          NOT NULL              ,
POINTS_SPEND_TRANS_QTY          INT                                ,
CREATED_BY_ID                   VARCHAR(100)   NOT NULL            ,
CREATED_DTTM                    DATETIME            NOT NULL       ,
LAST_UPDATED_BY_ID              VARCHAR(100)   NOT NULL        ,
LAST_UPDATED_DTTM               DATETIME            NOT NULL   ,
TRANSACTION_ID                        INT       ,                   
primary key(POINTS_SPEND_TRANS_DETAIL_ID)
)engine=innodb;


DROP TABLE IF EXISTS MEMBERSHIP;
CREATE TABLE MEMBERSHIP
( 
MEMBERSHIP_ID                   INT     AUTO_INCREMENT      NOT NULL                   ,
INITIAL_DTTM                    DATETIME             NOT NULL            ,
MEMBERSHIP_NUM                  VARCHAR(30)     NOT NULL                ,
STATUS_ID                       INT           NOT NULL                   ,
LAST_UPDATED_DTTM               DATETIME             NOT NULL        ,
LAST_UPDATED_BY_ID              VARCHAR(100)    NOT NULL            ,
CREATED_DTTM                    DATETIME             NOT NULL            ,
CREATED_BY_ID                   VARCHAR(100)    NOT NULL                 ,
ENTERPRISE_CD                   VARCHAR(10)     NOT NULL                 ,
PRODUCT_LINE_ID                 INT           NOT NULL                   ,
EXTERNAL_MEMBERSHIP_ID          VARCHAR(30)                              ,
MEMBER_TYPE_ID                  INT                                      ,
SOURCE_COMPANY_ID               INT                                      ,
LAST_NAME                       VARCHAR(100)    NOT NULL                 ,
FIRST_NAME                      VARCHAR(100)    NOT NULL                 ,
EMAIL                           VARCHAR(100)    NOT NULL                 ,
ADDRESS                         VARCHAR(100)    NOT NULL                 ,
CELL_PHONE                      VARCHAR(100)    NOT NULL                 ,                              
primary key(MEMBERSHIP_ID)
)engine=innodb;


DROP TABLE IF EXISTS COMPANY;
CREATE TABLE COMPANY                                           
(                                                             
COMPANY_ID                 INT    AUTO_INCREMENT      NOT NULL,
COMPANY_CD                 VARCHAR(10)    NOT NULL            ,
COMPANY_NAME               VARCHAR(100)   NOT NULL            ,
COMPANY_DESC               VARCHAR(250)                       ,
COMPANY_TYPE_CD            VARCHAR(10)    NOT NULL            ,
ELECTRONIC_ADDR_TXT        VARCHAR(100)                       ,
STATUS_ID                  INT          NOT NULL              ,
CREATED_BY_ID              VARCHAR(100)   NOT NULL            ,
CREATED_DTTM               DATETIME            NOT NULL           ,
LAST_UPDATED_BY_ID         VARCHAR(100)   NOT NULL            ,
LAST_UPDATED_DTTM          DATETIME            NOT NULL           ,               
primary key(COMPANY_ID)
)engine=innodb;



DROP TABLE IF EXISTS TRANSACTION_DETAIL;
CREATE TABLE TRANSACTION_DETAIL
(   
TRANSACTION_ID               INT   AUTO_INCREMENT         NOT NULL ,
TRANS_DETAIL_DTTM            DATETIME              NOT NULL           ,
MEMBERSHIP_ID                int                           ,
TRANS_TYPE_ID                INT            NOT NULL                  ,
USER_ID                      VARCHAR(30)                             ,
BATCH_HEADER_ID               INT                                     ,
REFERENCE_TRANS_DETAIL_ID     INT                                     ,
CURRENCY_ID                   INT(12)                                 ,
FEE_AMT                      decimal(18,4)      NOT NULL              ,
DISCOUNT_AMT                  decimal(18,4)                           ,
TAX_AMT                       decimal(18,4)                           ,
NET_AMT                       decimal(18,4)      NOT NULL             ,
OVERRIDE_AMT                  decimal(18,4)                           ,
OVERRIDE_REASON_CD            VARCHAR(10)                             ,
CREATED_BY_ID                 VARCHAR(100)     NOT NULL               ,
CREATED_DTTM                  DATETIME              NOT NULL          ,
LAST_UPDATED_BY_ID            VARCHAR(100)     NOT NULL           ,
LAST_UPDATED_DTTM             DATETIME              NOT NULL      ,
PRORATED_AMT                  decimal(18,4)                           ,
TRANS_COMPANY_ID              INT                                     ,
primary key(TRANSACTION_ID)
)engine=innodb;

DROP TABLE IF EXISTS product_membership;     
CREATE TABLE product_membership               
(
PRODUCT_MEMBERSHIP_ID          INT     AUTO_INCREMENT      NOT NULL               ,
MEMBERSHIP_ID                  INT           NOT NULL               ,
INITIAL_DTTM                   DATETIME             NOT NULL        ,
PRODUCT_ID                     INT           NOT NULL               ,
EXPIRATION_DTTM                DATETIME             NOT NULL        ,
BILLING_ENTITY_CD              VARCHAR(10)                          ,
AUTO_RENEWAL_IND               INT(1)        NOT NULL               ,
CREATED_BY_ID                  VARCHAR(100)    NOT NULL             ,
CREATED_DTTM                   DATETIME             NOT NULL        ,
LAST_UPDATED_BY_ID             VARCHAR(100)    NOT NULL             ,
LAST_UPDATED_DTTM              DATETIME             NOT NULL        ,
STATUS_ID                      INT           NOT NULL               ,
CUR_EFFECTIVE_DTTM             DATETIME             NOT NULL        ,
COMPANY_ID                     INT                                  ,
primary key(PRODUCT_MEMBERSHIP_ID)
)engine=innodb;

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT
(
PRODUCT_ID                INT   AUTO_INCREMENT          NOT NULL,
PRODUCT_CD                VARCHAR(10)       NOT NULL,
PRODUCT_NAME              VARCHAR(100)      NOT NULL,
PRODUCT_DESC              VARCHAR(250)              ,
EFFECTIVE_START_DTTM      DATETIME                       ,
EFFECTIVE_END_DTTM        DATETIME                       ,
STATUS_ID                 INT             NOT NULL,
CREATED_BY_ID             VARCHAR(100)      NOT NULL,
CREATED_DTTM              DATETIME               NOT NULL,
LAST_UPDATED_BY_ID        VARCHAR(100)      NOT NULL,
LAST_UPDATED_DTTM         DATETIME               NOT NULL,            
primary key(PRODUCT_ID)
)engine=innodb;


DROP TABLE IF EXISTS trans_payment;
CREATE TABLE trans_payment
(
TRANS_PAYMENT_ID             INT  AUTO_INCREMENT        NOT NULL ,
PAYMENT_AMT                  DECIMAL(18,4)    NOT NULL ,
TRANS_PAYMENT_DT             DATETIME            NOT NULL ,
PAYMENT_METHOD_CD            VARCHAR(10)    NOT NULL ,
USER_ID                      VARCHAR(30)             ,
PAYMENT_CURRENCY_ID          INT(12)      NOT NULL ,
COMPANY_ID                   INT                   ,
CHANNEL_CD                   VARCHAR(10)    NOT NULL ,
STATUS_ID                    INT          NOT NULL ,
BATCH_ID                     INT                   ,
CREATED_BY_ID                VARCHAR(100)   NOT NULL ,
CREATED_DTTM                 DATETIME            NOT NULL ,
LAST_UPDATED_BY_ID           VARCHAR(100)   NOT NULL ,
LAST_UPDATED_DTTM            DATETIME            NOT NULL ,
TRANS_PAYMENT_TYPE_ID        INT          NOT NULL ,
REFERENCE_TRANS_PAYMENT_ID   INT                   ,    
primary key(TRANS_PAYMENT_ID)
)engine=innodb;

DROP TABLE IF EXISTS trans_detail_payment;
CREATE TABLE trans_detail_payment
(
TRANS_DETAIL_PAYMENT_ID INT    AUTO_INCREMENT      NOT NULL           ,
TRANS_DETAIL_ID         INT          NOT NULL           ,
TRANS_PAYMENT_ID        INT          NOT NULL           ,
MEMBERSHIP_ID           INT                             ,
PAYMENT_AMT             DECIMAL(18,4)                   ,
LAST_UPDATED_DTTM       DATETIME            NOT NULL    ,
LAST_UPDATED_BY_ID      VARCHAR(100)   NOT NULL         ,
CREATED_DTTM            DATETIME            NOT NULL    ,
CREATED_BY_ID           VARCHAR(100)   NOT NULL         ,
CREDIT_TRANS_DETAIL_ID  INT                             ,
primary key(TRANS_DETAIL_PAYMENT_ID)
)engine=innodb;

DROP TABLE IF EXISTS payment_method;
CREATE TABLE payment_method
(
PAYMENT_METHOD_CD       VARCHAR(10)    NOT NULL      ,
PAYMENT_METHOD_DESC     VARCHAR(250)                 ,
ACTIVE_IND              INT(1)       NOT NULL        ,
LAST_UPDATED_DTTM       DATETIME            NOT NULL ,
LAST_UPDATED_BY_ID      VARCHAR(100)   NOT NULL      ,
primary key(PAYMENT_METHOD_CD)
)engine=innodb;





alter table Points_account add constraint PROGRAM2Points_account_fk foreign key(PROGRAM_ID) references PROGRAM(PROGRAM_ID);
alter table Points_account add constraint MEMBERSHIP2Points_account_fk foreign key(MEMBERSHIP_ID) references MEMBERSHIP(MEMBERSHIP_ID);
alter table Points_account add constraint POINTS_ACCOUNT_TYPE2Points_account_fk foreign key(POINTS_ACCOUNT_TYPE_CD) references POINTS_ACCOUNT_TYPE(POINTS_ACCOUNT_TYPE_CD);
alter table Points_account add constraint STATUS2Points_account_fk foreign key(STATUS_ID) references STATUS(STATUS_ID);
create index Points_account_ix1 on Points_account(PROGRAM_ID);
create index Points_account_ix2 on Points_account(MEMBERSHIP_ID);
create index Points_account_ix3 on Points_account(POINTS_ACCOUNT_TYPE_CD);
create index Points_account_ix4 on Points_account(STATUS_ID);



create index PROGRAM_IX1 on PROGRAM(PROGRAM_CD);
create unique index STATUS_AK1 on STATUS(STATUS_CD,STATUS_CAT_NAME);



alter table POINTS_DEPOSIT_TRANS_DETAIL add constraint POINTS_ACCOUNT2POINTS_DEPOSIT_TRANS_DETAIL_fk foreign key(POINTS_ACCOUNT_ID) references POINTS_ACCOUNT(POINTS_ACCOUNT_ID);
alter table POINTS_DEPOSIT_TRANS_DETAIL add constraint POINTS_TRANS_HEADER2POINTS_DEPOSIT_TRANS_DETAIL_fk foreign key(POINTS_TRANS_HEADER_ID) references POINTS_TRANS_HEADER(POINTS_TRANS_HEADER_ID);
alter table POINTS_DEPOSIT_TRANS_DETAIL add constraint TRANS_TYPE2POINTS_DEPOSIT_TRANS_DETAIL_fk foreign key(TRANS_TYPE_ID) references TRANS_TYPE(TRANS_TYPE_ID);
alter table POINTS_DEPOSIT_TRANS_DETAIL add constraint TRANSACTION2POINTS_DEPOSIT_TRANS_DETAIL_fk foreign key(TRANSACTION_ID) references TRANSACTION_DETAIL(TRANSACTION_ID);
alter table POINTS_DEPOSIT_TRANS_DETAIL add constraint POINTS_SPEND_TRANS_DETAIL2POINTS_DEPOSIT_TRANS_DETAIL_fk foreign key(POINTS_SPEND_TRANS_DETAIL_ID) references POINTS_SPEND_TRANS_DETAIL(POINTS_SPEND_TRANS_DETAIL_ID);
create index POINTS_DEPOSIT_TRANS_DETAIL_IX1 on POINTS_DEPOSIT_TRANS_DETAIL(POINTS_ACCOUNT_ID);
create index POINTS_DEPOSIT_TRANS_DETAIL_IX2 on POINTS_DEPOSIT_TRANS_DETAIL(POINTS_TRANS_HEADER_ID);
create index POINTS_DEPOSIT_TRANS_DETAIL_IX3 on POINTS_DEPOSIT_TRANS_DETAIL(TRANS_TYPE_ID);
create index POINTS_DEPOSIT_TRANS_DETAIL_IX4 on POINTS_DEPOSIT_TRANS_DETAIL(TRANSACTION_ID);
create index POINTS_DEPOSIT_TRANS_DETAIL_IX5 on POINTS_DEPOSIT_TRANS_DETAIL(POINTS_SPEND_TRANS_DETAIL_ID);


create unique index TRANS_TYPE_ak1 on TRANS_TYPE(TRANS_TYPE_CD,CAT_CD);

alter table POINTS_TRANS_HEADER add constraint MEMBERSHIP2POINTS_TRANS_HEADER_fk foreign key(MEMBERSHIP_ID) references MEMBERSHIP(MEMBERSHIP_ID);
alter table POINTS_TRANS_HEADER add constraint COMPANY2POINTS_TRANS_HEADER_fk foreign key(COMPANY_ID) references COMPANY(COMPANY_ID);
create index POINTS_TRANS_HEADER_ix1 on POINTS_TRANS_HEADER(MEMBERSHIP_ID);
create index POINTS_TRANS_HEADER_ix2 on POINTS_TRANS_HEADER(COMPANY_ID);

alter table POINTS_SPEND_TRANS_DETAIL add constraint POINTS_DEPOSIT_TRANS_DETAIL2POINTS_SPEND_TRANS_DETAIL_fk foreign key(POINTS_DEPOSIT_TRANS_DETAIL_ID) references POINTS_DEPOSIT_TRANS_DETAIL(POINTS_DEPOSIT_TRANS_DETAIL_ID);
alter table POINTS_SPEND_TRANS_DETAIL add constraint POINTS_TRANS_HEADER2POINTS_SPEND_TRANS_DETAIL_fk foreign key(POINTS_TRANS_HEADER_ID) references POINTS_TRANS_HEADER(POINTS_TRANS_HEADER_ID);
alter table POINTS_SPEND_TRANS_DETAIL add constraint TRANS_TYPE2POINTS_SPEND_TRANS_DETAIL_fk foreign key(TRANS_TYPE_ID) references TRANS_TYPE(TRANS_TYPE_ID);
alter table POINTS_SPEND_TRANS_DETAIL add constraint TRANSACTION2POINTS_SPEND_TRANS_DETAIL_fk foreign key(TRANSACTION_ID) references TRANSACTION_DETAIL(TRANSACTION_ID);
create index POINTS_SPEND_TRANS_DETAIL_ix1 on POINTS_SPEND_TRANS_DETAIL(POINTS_DEPOSIT_TRANS_DETAIL_ID);
create index POINTS_SPEND_TRANS_DETAIL_ix2 on POINTS_SPEND_TRANS_DETAIL(POINTS_TRANS_HEADER_ID);
create index POINTS_SPEND_TRANS_DETAIL_ix3 on POINTS_SPEND_TRANS_DETAIL(TRANS_TYPE_ID);
create index POINTS_SPEND_TRANS_DETAIL_ix4 on POINTS_SPEND_TRANS_DETAIL(TRANSACTION_ID);


alter table MEMBERSHIP add constraint status2MEMBERSHIP_fk foreign key(STATUS_ID) references STATUS(STATUS_ID);
alter table MEMBERSHIP add constraint COMPANY2MEMBERSHIP_fk foreign key(SOURCE_COMPANY_ID) references COMPANY(COMPANY_ID);
create index MEMBERSHIP_ix1 on MEMBERSHIP(MEMBERSHIP_NUM);
create index MEMBERSHIP_ix2 on MEMBERSHIP(STATUS_ID);
create index MEMBERSHIP_ix3 on MEMBERSHIP(SOURCE_COMPANY_ID);



alter table COMPANY add constraint status2COMPANY_fk foreign key(STATUS_ID) references STATUS(STATUS_ID);
create index COMPANY_ix1 on COMPANY(COMPANY_CD);
create index COMPANY_ix2 on COMPANY(STATUS_ID);

alter table TRANSACTION_DETAIL add constraint MEMBERSHIP2TRANSACTION_DETAIL_fk foreign key(MEMBERSHIP_ID) references MEMBERSHIP(MEMBERSHIP_ID);
alter table TRANSACTION_DETAIL add constraint TRANS_TYPE2TRANSACTION_DETAIL_fk foreign key(TRANS_TYPE_ID) references TRANS_TYPE(TRANS_TYPE_ID);
alter table TRANSACTION_DETAIL add constraint TRANSACTION_DETAIL2TRANSACTION_DETAIL_fk foreign key(REFERENCE_TRANS_DETAIL_ID) references TRANSACTION_DETAIL(TRANSACTION_ID);

create index TRANSACTION_DETAIL_IX1 on TRANSACTION_DETAIL(MEMBERSHIP_ID);
create index TRANSACTION_DETAIL_IX2 on TRANSACTION_DETAIL(TRANS_TYPE_ID);
create index TRANSACTION_DETAIL_IX3 on TRANSACTION_DETAIL(REFERENCE_TRANS_DETAIL_ID);

/*new add script for highlight part change*/
alter table TRANSACTION_DETAIL add column PRODUCT_MEMBERSHIP_ID INT;
ALTER TABLE TRANSACTION_DETAIL add constraint PRODUCT_MEMBERSHIP2TRANSACTION_DETAIL_FK  foreign key(PRODUCT_MEMBERSHIP_ID) references PRODUCT_MEMBERSHIP(PRODUCT_MEMBERSHIP_ID);
create index TRANSACTION_DETAIL_IX4 on TRANSACTION_DETAIL(PRODUCT_MEMBERSHIP_ID);

ALTER TABLE product_membership add constraint MEMBERSHIP2product_membership_fk foreign key(MEMBERSHIP_ID) references MEMBERSHIP(MEMBERSHIP_ID);
ALTER TABLE product_membership add constraint status2product_membership_fk foreign key(STATUS_ID) references STATUS(STATUS_ID);
ALTER TABLE product_membership add constraint company2product_membership_fk foreign key(COMPANY_ID) references COMPANY(COMPANY_ID);
ALTER TABLE product_membership add constraint PRODUCT2product_membership_fk foreign key(PRODUCT_ID) references PRODUCT(PRODUCT_ID);

create index product_membership_ix1 on product_membership(MEMBERSHIP_ID);
create index product_membership_ix2 on product_membership(PRODUCT_ID);
create index product_membership_ix3 on product_membership(STATUS_ID );
create index product_membership_ix4 on product_membership(COMPANY_ID);
   
ALTER TABLE product add constraint status2product_fk foreign key(STATUS_ID) references STATUS(STATUS_ID);
create index product_ix1 on product(STATUS_ID);   


ALTER TABLE trans_payment ADD CONSTRAINT PAYMENT_METHOD2trans_payment_FK foreign key(PAYMENT_METHOD_CD) references PAYMENT_METHOD(PAYMENT_METHOD_CD);   
ALTER TABLE trans_payment ADD CONSTRAINT status2trans_payment_FK foreign key(STATUS_ID) references STATUS(STATUS_ID);   
ALTER TABLE trans_payment ADD CONSTRAINT COMPANY2trans_payment_FK foreign key(COMPANY_ID) references COMPANY(COMPANY_ID);  
ALTER TABLE trans_payment ADD CONSTRAINT trans_payment2trans_payment_FK foreign key(REFERENCE_TRANS_PAYMENT_ID) references trans_payment(TRANS_PAYMENT_ID);  

create index trans_payment_ix1 on trans_payment(PAYMENT_METHOD_CD);
create index trans_payment_ix2 on trans_payment(STATUS_ID );
create index trans_payment_ix3 on trans_payment(COMPANY_ID);
create index trans_payment_ix4 on trans_payment(REFERENCE_TRANS_PAYMENT_ID);

ALTER TABLE trans_detail_payment add constraint MEMBERSHIP2trans_detail_payment_fk foreign key(MEMBERSHIP_ID) references MEMBERSHIP(MEMBERSHIP_ID);
alter table trans_detail_payment add constraint TRANSACTION_DETAIL2trans_detail_payment_fk foreign key(TRANS_DETAIL_ID) references TRANSACTION_DETAIL(TRANSACTION_ID);
alter table trans_detail_payment add constraint TRANS_PAYMENT2trans_detail_payment_fk foreign key(TRANS_PAYMENT_ID) references TRANS_PAYMENT(TRANS_PAYMENT_ID);


create index trans_detail_payment_ix1 on trans_detail_payment(TRANS_DETAIL_ID);
create index trans_detail_payment_ix2 on trans_detail_payment(TRANS_PAYMENT_ID);
create index trans_detail_payment_ix3 on trans_detail_payment(MEMBERSHIP_ID);
