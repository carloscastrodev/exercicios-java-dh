create schema if not exists empresa;
use empresa;

create table if not exists `usuarios` (
	id_usuario int primary key auto_increment,
    nome varchar(255) not null,
    usuario varchar(255) not null unique,
    senha varchar(255) not null,
    habilitado boolean default true,
    salario double not null default 0,
    papel varchar(24) not null,
    cargo varchar(64) not null
    
) engine = InnoDB;

create table if not exists `clientes` (
	id_cliente int primary key auto_increment,
	nome varchar(255) not null,
    email varchar(255) not null unique,
    cpf varchar(14) not null,
    senha varchar(255) not null,
    habilitado boolean default true
) engine = InnoDB;


CREATE TABLE IF NOT EXISTS `produtos` (
  `id_produto` int NOT NULL auto_increment,
  `nome` varchar(70) NOT NULL,
  `descricao` text NOT NULL,
  `estoque` int NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `pedidos` (
	nfe VARCHAR(50) PRIMARY KEY DEFAULT 0,
    data_emissao DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL DEFAULT 0,
    status_pedido VARCHAR(30) DEFAULT "Processando",
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `produtos_pedidos` (
	fk_produto INT NOT NULL,
    fk_pedido VARCHAR(50) NOT NULL,
    quantidade_produto INT,
    FOREIGN KEY (fk_produto) REFERENCES produtos(id_produto),
    FOREIGN KEY (fk_pedido) REFERENCES pedidos(nfe)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ponto_funcionario` (
	id_ponto int not null auto_increment,
	id_funcionario INT NOT NULL,
    entrada DATE NOT NULL,
    saida DATE NOT NULL,
    PRIMARY KEY (id_ponto)
) ENGINE = InnoDB;


insert  into `produtos`(`nome`,`descricao`,`estoque`,`preco`) values 

('Pasta de Dente Colgate', 'Pasta de dente da Colgate', 2000, '6.99'),

('Pasta de Dente Even', 'Pasta de dente da Even', 2000, '3.99'),

('Pasta de Dente Close Up', 'Pasta de dente da Close Up', 2000, '6.99'),

('Pasta de Dente Sensodyne', 'Pasta de dente da Sensodyne', 500, '12.99'),

('Macarrão Parafuso Renata', 'Macarrão parafuso da marca Renata', 1000, '7.99'),

('Macarrão Penne Renata', 'Macarrão penne da marca Renata', 1000, '8.99'),

('Macarrão Parafuso Barilia', 'Macarrão parafuso da marca Barilia', 1000, '9.99'),

('Macarrão Penne Barilia', 'Macarrão parafuso da marca Barilia', 1000, '11.99'),

('Cebola' ,'Cebola 1,99 o kg',1000,'1.99'),

('Tomate' ,'Tomate 5,99 o kg',1000,'5.99'),

('Banana' ,'Banana 12,99 o kg',1000,'12.99'),

('Melancia' ,'Melancia 15,99 a unidade',1000,'15.99'),

('Melão' ,'Melão 8,99 a unidade',1000,'8.99'),

('Ovo' ,'Ovos 13,99 cartela c/ 24',1000,'13.99'),

('Chocolate Lacta' ,'Chocolate barra 400g marca Lacta',1000,'31.99'),

('Chocolate Branco Lacta' ,'Chocolate branco barra 400g marca Lacta',1000,'25.99'),

('Chocolate Hersheys' ,'Chocolate barra 400g marca Hersheys',1000,'36.99'),

('Chocolate Branco Hersheys' ,'Chocolate branco barra 400g marca Hersheys',1000,'30.99'),

('Óleo de Soja Liza' ,'Óleo de Soja da marca Liza 900ml',1000,'12.99'),

('Óleo de Soja Soya' ,'Óleo de Soja da marca Soya 900ml',1000,'13.99'),

('Arroz 5kg' ,'Pacote de Arroz 5kg',1000,'80.99'),

('Feijão 1kg' ,'Pacote de Feijão 1kg',1000,'28.99'),

('Café 1kg' ,'Pacote de Café 1kg',1000,'18.99'),

('Açúcar 1kg' ,'Pacote de Açúcar 1kg',1000,'18.99'),

('Sal 1kg' ,'Pacote de Sal 1kg',1000,'14.99'),

('Macarrão Instantâneo de Carne' ,'Pacote de macarrão instantâneo de carne Nissin',1000,'3.99'),

('Macarrão Instantâneo de Frango' ,'Pacote de macarrão instantâneo de frango Nissin',1000,'4.99'),

('Macarrão Instantâneo de Legumes' ,'Pacote de macarrão instantâneo de legumes Nissin',1000,'2.99'),

('Macarrão Instantâneo de Costela' ,'Pacote de macarrão instantâneo de costela Nissin',1000,'5.99'),

('Bala Halls' ,'Bala Halls sabor menta extra forte ',1000,'2.49');

insert into `usuarios`(nome, usuario, senha, papel, salario, cargo) values ('João Silva', 'funcionario_1', '123456', 'ROLE_FUNC', 1500, 'Funcionário');
insert into `usuarios`(nome, usuario, senha, papel, salario, cargo) values ('Pedro Nascimento', 'gerente_1', '123456', 'ROLE_GERN', 2800, 'Gerente');	

