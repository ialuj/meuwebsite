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
       avenue_road varchar(255) not null,
       house_number varchar(255) not null,
       primary key(id),
       constraint ct_rg unique(rg),
       constraint ct_cpf unique(cpf));
       
insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(1, 'Ana Maria dos Santos', '1991-03-10', '324125239', '17632330909', '15 98118 3885', 'ana.santos@gmail.com', 'SP', 'Bairro da Tijuca', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(2, 'Ana Paulo Gabriela', '1995-04-25', '125565616', '39858767463', '15 98118 3885', 'ana.gabrila@gmail.com', 'RJ', 'Caju', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(3, 'João Paulo Miguel', '1988-03-10', '429654376', '74856178504', '15 98118 3885', 'joao.paulo.mg@gmail.com', 'ES', 'Bairro da Tijuca', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(4, 'Mário Costa', '1987-03-10', '214968315', '45654177583', '15 98118 3885', 'mario.costa@gmail.com', 'SP', 'Cambuci', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(5, 'Inácio Damasceno', '1992-03-10', '248524276', '84793544029', '15 98118 3885', 'inacio.damasceno@gmail.com', 'SP', 'Casa Verde', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(6, 'Gabriel Jesus', '1999-03-10', '436847371', '49711512491', '15 98118 3885', 'gabriel.jesus@gmail.com', 'RJ', 'Flamengo', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(7, 'Marta de Jesus', '1993-03-10', '470134343', '58318463773', '15 98118 3885', 'marta.de.jesus@gmail.com', 'SP', 'Vila Andrade', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(8, 'Rodrigo Faro', '1994-03-10', '338489460', '41167236491', '15 98118 3885', 'rodriguiro.faro@gmail.com', 'MG', 'Bairro da Tijuca', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(9, 'Taís Araújo', '1995-03-10', '414863318', '14948496316', '15 98118 3885', 'tais.araujo@gmail.com', 'SP', 'Raposo Tavares', 'Av. Sao Joao', '345');

insert into client(id, full_name, birth_date, rg, cpf, phone_number, email, state, neighbourhood, avenue_road, house_number)
values(10, 'Sílvio Santos', '1981-03-10', '417323141', '46456589487', '15 98118 3885', 'silvio.santos@gmail.com', 'SP', 'Bairro da Tijuca', 'Av. Sao Joao', '345');
