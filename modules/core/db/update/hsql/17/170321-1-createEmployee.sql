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
);
