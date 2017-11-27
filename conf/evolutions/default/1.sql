# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table pessoa (
  id                            bigint(11) auto_increment not null,
  nome                          varchar(45) not null,
  cpf                           varchar(45) not null,
  nascimento                    varchar(45),
  peso                          decimal(38),
  uf                            varchar(45),
  constraint pk_pessoa primary key (id)
);


# --- !Downs

drop table if exists pessoa;

