create table wbrio.documentos_interfaces
  (doin_id number(10) not null
  ,doin_nome varchar2(80) not null
  ,doin_descricao varchar2(512)
  ,constraint doin_pk primary key(doin_id)
  ,constraint doin_nome_uk unique(doin_nome));

create table wbrio.acessos_documentos_interfaces
  (acdi_id number(10) not null
  ,acdi_doin_id number(10) not null
  ,acdi_usua_id number(10) not null
  ,constraint acdi_pk primary key(acdi_id)
  ,constraint acdi_uk unique(acdi_doin_id, acdi_usua_id)
  ,constraint tedi_doin_fk foreign key(acdi_doin_id)
    references documentos_interfaces(doin_id)
  ,constraint acdi_usua_fk foreign key(acdi_usua_id)
    references usuarios(usua_id));

create table wbrio.menus
  (menu_id number(10) not null
  ,menu_nome varchar2(80) not null
  ,menu_texto varchar2(255) not null
  ,menu_pai_menu_id number(10)
  ,constraint menu_pk primary key(menu_id)
  ,constraint menu_uk unique(menu_mome));

create table wbrio.itens_menus
  (itme_id number(10) not null
  ,itme_nome varchar2(80) not null
  ,itme_texto varchar2(255) not null
  ,itme_comando varchar2(255) not null
  ,itme_menu_id number(10) not null
  ,itme_doin_id number(10)
  ,constraint itme_pk primary key(itme_id)
  ,constraint itme_nome_uk unique(itme_nome)
  ,constraint itme_doin_fk foreign key(itme_doin_id)
    references documentos_interfaces(doin_id)
  ,constraint itme_menu_fk foreign key(itme_menu_id)
    references menus(menu_id));

create sequence wbrio.documentos_interfaces_seq
  start with 0
  increment by 1
  minvalue = 1
  nocache
  nocycle
  order;

create sequence wbrio.menus_seq
  start with 0
  increment by 1
  minvalue = 1
  nocache
  nocycle
  order;

create sequence wbrio.acessos_seq
  start with 0
  increment by 1
  minvalue = 1
  nocache
  nocycle
  order;
