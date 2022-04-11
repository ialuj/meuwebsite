drop table if exists client;

create table if not exists
client(id int auto_increment not null,
       full_name varchar(255) not null,
       birth_date date not null,
       rg varchar(255) not null,
       cpf varchar(255) not null,
       phone_number varchar(255),
       email varchar(255),
       state varchar(255) not null,
       neighbourhood varchar(255) not null,
       avenue_or_road varchar(255) not null,
       house_number varchar(255) not null,
       primary key(id),
       constraint ct_rg unique(rg),
       constraint ct_cpf unique(cpf));
       
insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_or_road, house_number)
values(1, 'Ana Maria dos Santos', '1991-03-10', '', '', '', 'ana.santos@gmail.com', 'SP', '', '', '');

