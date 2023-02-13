-- Create table
create table ACESSOS_DOCUMENTOS_INTERFACES
(
  ACDI_ID      NUMBER(10) not null,
  ACDI_DOIN_ID NUMBER(10) not null,
  ACDI_USUA_ID NUMBER(10) not null
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ACESSOS_DOCUMENTOS_INTERFACES
  add constraint ACDI_PK primary key (ACDI_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_DOCUMENTOS_INTERFACES
  add constraint ACDI_UK unique (ACDI_DOIN_ID, ACDI_USUA_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_DOCUMENTOS_INTERFACES
  add constraint ACDI_USUA_FK foreign key (ACDI_USUA_ID)
  references USUARIOS (USUA_ID);
alter table ACESSOS_DOCUMENTOS_INTERFACES
  add constraint TEDI_DOIN_FK foreign key (ACDI_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on ACESSOS_DOCUMENTOS_INTERFACES to PADRAO_BRIO;
grant delete on ACESSOS_DOCUMENTOS_INTERFACES to ROLE_DELETE;
grant insert on ACESSOS_DOCUMENTOS_INTERFACES to ROLE_INSERT;
grant select on ACESSOS_DOCUMENTOS_INTERFACES to ROLE_SELECT;
grant update on ACESSOS_DOCUMENTOS_INTERFACES to ROLE_UPDATE;

-- Create table
create table ACESSOS_ENTIDADES_NEGOCIO
(
  ACEN_ID      NUMBER(10) not null,
  ACEN_ENNE_ID NUMBER(10) not null,
  ACEN_DOIN_ID NUMBER(10) not null
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ACESSOS_ENTIDADES_NEGOCIO
  add constraint ACEN_PK primary key (ACEN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_ENTIDADES_NEGOCIO
  add constraint ACEN_UK unique (ACEN_ENNE_ID, ACEN_DOIN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_ENTIDADES_NEGOCIO
  add constraint ACEN_DOIN_FK foreign key (ACEN_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
alter table ACESSOS_ENTIDADES_NEGOCIO
  add constraint ACEN_ENNE_FK foreign key (ACEN_ENNE_ID)
  references ENTIDADES_NEGOCIO (ENNE_ID);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on ACESSOS_ENTIDADES_NEGOCIO to PADRAO_BRIO;
grant insert on ACESSOS_ENTIDADES_NEGOCIO to ROLE_INSERT;
grant select on ACESSOS_ENTIDADES_NEGOCIO to ROLE_SELECT;
grant update on ACESSOS_ENTIDADES_NEGOCIO to ROLE_UPDATE;


-- Create table
create table ACESSOS_TIPOS_ENTIDADE_NEGOCIO
(
  ATEN_ID      NUMBER(10) not null,
  ATEN_TIEN_ID NUMBER(10) not null,
  ATEN_DOIN_ID NUMBER(10) not null
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ACESSOS_TIPOS_ENTIDADE_NEGOCIO
  add constraint ATEN_PK primary key (ATEN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_TIPOS_ENTIDADE_NEGOCIO
  add constraint ATEN_UK unique (ATEN_TIEN_ID, ATEN_DOIN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_TIPOS_ENTIDADE_NEGOCIO
  add constraint ATEN_DOIN_FK foreign key (ATEN_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
alter table ACESSOS_TIPOS_ENTIDADE_NEGOCIO
  add constraint ATEN_TIEN_FK foreign key (ATEN_TIEN_ID)
  references TIPOS_ENTIDADE_NEGOCIO (TIEN_ID);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on ACESSOS_TIPOS_ENTIDADE_NEGOCIO to PADRAO_BRIO;
grant insert on ACESSOS_TIPOS_ENTIDADE_NEGOCIO to ROLE_INSERT;
grant select on ACESSOS_TIPOS_ENTIDADE_NEGOCIO to ROLE_SELECT;
grant update, delete on ACESSOS_TIPOS_ENTIDADE_NEGOCIO to ROLE_UPDATE;


-- Create table
create table ACESSOS_USUARIOS
(
  ACUS_ID           NUMBER(10) not null,
  ACUS_USUA_ID      NUMBER(10) not null,
  ACUS_DOIN_ID      NUMBER(10) not null,
  ACUS_NEGAR_ACESSO VARCHAR2(1) default 'N' not null
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ACESSOS_USUARIOS
  add constraint ACUS_PK primary key (ACUS_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_USUARIOS
  add constraint ACUS_UK unique (ACUS_USUA_ID, ACUS_DOIN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ACESSOS_USUARIOS
  add constraint ACUS_DOIN_FK foreign key (ACUS_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
alter table ACESSOS_USUARIOS
  add constraint ACUS_USUA_FK foreign key (ACUS_USUA_ID)
  references USUARIOS (USUA_ID);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on ACESSOS_USUARIOS to PADRAO_BRIO;
grant delete on ACESSOS_USUARIOS to ROLE_DELETE;
grant insert on ACESSOS_USUARIOS to ROLE_INSERT;
grant select on ACESSOS_USUARIOS to ROLE_SELECT;
grant update on ACESSOS_USUARIOS to ROLE_UPDATE;


-- Create table
create table DOCUMENTOS_INTERFACES
(
  DOIN_ID        NUMBER(10) not null,
  DOIN_NOME      VARCHAR2(80) not null,
  DOIN_DESCRICAO VARCHAR2(512)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table DOCUMENTOS_INTERFACES
  add constraint DOIN_PK primary key (DOIN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table DOCUMENTOS_INTERFACES
  add constraint DOIN_NOME_UK unique (DOIN_NOME)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Grant/Revoke object privileges 
grant select, insert, update, delete on DOCUMENTOS_INTERFACES to PADRAO_BRIO;
grant delete on DOCUMENTOS_INTERFACES to ROLE_DELETE;
grant insert on DOCUMENTOS_INTERFACES to ROLE_INSERT;
grant select on DOCUMENTOS_INTERFACES to ROLE_SELECT;
grant update on DOCUMENTOS_INTERFACES to ROLE_UPDATE;


-- Create table
create table ENTIDADES_NEGOCIO
(
  ENNE_ID        NUMBER(10) not null,
  ENNE_DESCRICAO VARCHAR2(255) not null,
  ENNE_CHAVE     VARCHAR2(255) not null,
  ENNE_TIEN_ID   NUMBER(10)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ENTIDADES_NEGOCIO
  add constraint ENNE_PK primary key (ENNE_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ENTIDADES_NEGOCIO
  add constraint ENNE_UK unique (ENNE_DESCRICAO)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ENTIDADES_NEGOCIO
  add constraint ENNE_TIEN_FK foreign key (ENNE_TIEN_ID)
  references TIPOS_ENTIDADE_NEGOCIO (TIEN_ID);
-- Grant/Revoke object privileges 
grant select, update, delete on ENTIDADES_NEGOCIO to PADRAO_BRIO;


-- Create table
create table ITENS_MENUS
(
  ITME_ID      NUMBER(10) not null,
  ITME_NOME    VARCHAR2(80) not null,
  ITME_TEXTO   VARCHAR2(255) not null,
  ITME_COMANDO VARCHAR2(255) not null,
  ITME_MENU_ID NUMBER(10) not null,
  ITME_DOIN_ID NUMBER(10)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ITENS_MENUS
  add constraint ITME_PK primary key (ITME_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ITENS_MENUS
  add constraint ITME_NOME_UK unique (ITME_NOME)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ITENS_MENUS
  add constraint ITME_DOIN_FK foreign key (ITME_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
alter table ITENS_MENUS
  add constraint ITME_MENU_FK foreign key (ITME_MENU_ID)
  references MENUS (MENU_ID);


-- Create table
create table ITENS_MENUS
(
  ITME_ID      NUMBER(10) not null,
  ITME_NOME    VARCHAR2(80) not null,
  ITME_TEXTO   VARCHAR2(255) not null,
  ITME_COMANDO VARCHAR2(255) not null,
  ITME_MENU_ID NUMBER(10) not null,
  ITME_DOIN_ID NUMBER(10)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ITENS_MENUS
  add constraint ITME_PK primary key (ITME_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ITENS_MENUS
  add constraint ITME_NOME_UK unique (ITME_NOME)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table ITENS_MENUS
  add constraint ITME_DOIN_FK foreign key (ITME_DOIN_ID)
  references DOCUMENTOS_INTERFACES (DOIN_ID);
alter table ITENS_MENUS
  add constraint ITME_MENU_FK foreign key (ITME_MENU_ID)
  references MENUS (MENU_ID);


-- Create table
create table MENUS
(
  MENU_ID          NUMBER(10) not null,
  MENU_NOME        VARCHAR2(80) not null,
  MENU_TEXTO       VARCHAR2(255) not null,
  MENU_PAI_MENU_ID NUMBER(10)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table MENUS
  add constraint MENU_PK primary key (MENU_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table MENUS
  add constraint MENU_UK unique (MENU_NOME)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Grant/Revoke object privileges 
grant select, insert, update, delete on MENUS to PADRAO_BRIO;
grant delete on MENUS to ROLE_DELETE;
grant insert on MENUS to ROLE_INSERT;
grant select on MENUS to ROLE_SELECT;
grant update on MENUS to ROLE_UPDATE;

-- Create table
create table TIPOS_ENTIDADE_NEGOCIO
(
  TIEN_ID           NUMBER(10) not null,
  TIEN_TIPO         VARCHAR2(40) not null,
  TIEN_TABELA       VARCHAR2(30) not null,
  TIEN_CAMPOS_DESCR VARCHAR2(255) not null,
  TIEN_CAMPOS_CHAVE VARCHAR2(255) not null,
  TIEN_CONDICIONAL  VARCHAR2(255)
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table TIPOS_ENTIDADE_NEGOCIO
  add constraint TIEN_PK primary key (TIEN_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table TIPOS_ENTIDADE_NEGOCIO
  add constraint TIEN_TABELA_UK unique (TIEN_TABELA)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table TIPOS_ENTIDADE_NEGOCIO
  add constraint TIEN_TIPO_UK unique (TIEN_TIPO)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Grant/Revoke object privileges 
grant select, update, delete on TIPOS_ENTIDADE_NEGOCIO to PADRAO_BRIO;


-- Create table
create table USUARIOS
(
  USUA_ID       NUMBER(10) not null,
  USUA_NOME     VARCHAR2(40) not null,
  USUA_USUARIO  VARCHAR2(30) not null,
  USUA_SENHA    VARCHAR2(32) not null,
  USUA_SUPER    VARCHAR2(1) default 'N' not null,
  USUA_ENNE_ID  NUMBER(10),
  USUA_DT_SENHA DATE not null
)
tablespace BRIO_DATA
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 80K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table USUARIOS
  add constraint USUA_PK primary key (USUA_ID)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table USUARIOS
  add constraint USUA_NOME_UK unique (USUA_NOME)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table USUARIOS
  add constraint USUA_USUARIO_UK unique (USUA_USUARIO)
  using index 
  tablespace BRIO_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40K
    next 40K
    minextents 1
    maxextents 505
    pctincrease 50
  );
alter table USUARIOS
  add constraint USUA_ENNE_FK foreign key (USUA_ENNE_ID)
  references ENTIDADES_NEGOCIO (ENNE_ID);
-- Grant/Revoke object privileges 
grant select, update, delete on USUARIOS to PADRAO_BRIO;