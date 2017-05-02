-- begin CUBATRAININGTASK_CITY
create table CUBATRAININGTASK_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    CODE varchar(100) not null,
    DEFAULT_CITY boolean,
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_CITY
-- begin CUBATRAININGTASK_CUSTOMER
create table CUBATRAININGTASK_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(100),
    PHONE varchar(100),
    EMAIL varchar(255),
    CENTER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_CUSTOMER
-- begin CUBATRAININGTASK_INDIVIDUAL
create table CUBATRAININGTASK_INDIVIDUAL (
    ID varchar(36) not null,
    --
    PASSPORT_NO integer not null,
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_INDIVIDUAL
-- begin CUBATRAININGTASK_COMPANY
create table CUBATRAININGTASK_COMPANY (
    ID varchar(36) not null,
    --
    INN integer not null,
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_COMPANY
-- begin CUBATRAININGTASK_CAR_SERVICE_CENTER
create table CUBATRAININGTASK_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    PHONE varchar(255),
    CITY_ID varchar(36),
    ADDRESS varchar(255),
    CREATOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_CAR_SERVICE_CENTER
-- begin CUBATRAININGTASK_EMPLOYEE
create table CUBATRAININGTASK_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    BIRTH_DATE date,
    EMAIL varchar(255),
    SALARY double precision,
    CENTER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_EMPLOYEE
-- begin CUBATRAININGTASK_REPAIR
create table CUBATRAININGTASK_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    EMPLOYEE_ID varchar(36),
    CAR_SERVICE_CENTER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBATRAININGTASK_REPAIR
