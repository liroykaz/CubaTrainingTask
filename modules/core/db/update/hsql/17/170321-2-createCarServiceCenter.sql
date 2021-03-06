alter table CUBATRAININGTASK_CAR_SERVICE_CENTER add constraint FK_CUBATRAININGTASK_CAR_SERVICE_CENTER_CITY foreign key (CITY_ID) references CUBATRAININGTASK_CITY(ID);
alter table CUBATRAININGTASK_CAR_SERVICE_CENTER add constraint FK_CUBATRAININGTASK_CAR_SERVICE_CENTER_REPAIR foreign key (REPAIR_ID) references CUBATRAININGTASK_REPAIR(ID);
create index IDX_CUBATRAININGTASK_CAR_SERVICE_CENTER_CITY on CUBATRAININGTASK_CAR_SERVICE_CENTER (CITY_ID);
create index IDX_CUBATRAININGTASK_CAR_SERVICE_CENTER_REPAIR on CUBATRAININGTASK_CAR_SERVICE_CENTER (REPAIR_ID);
