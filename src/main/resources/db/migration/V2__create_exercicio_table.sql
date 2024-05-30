CREATE TABLE exercicio(
    id bigint not null auto_increment,
    nome varchar(50),
    series varchar(10),
    repeticoes varchar(10),
    treino_id bigint,
    primary key(id),
    foreign key (treino_id) references treino(id)
)