# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table pessoa (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  cpf                           varchar(255),
  nascimento                    bigint,
  peso                          decimal(38),
  uf                            varchar(255),
  constraint pk_pessoa primary key (id)
);


# --- !Downs

drop table if exists pessoa;

