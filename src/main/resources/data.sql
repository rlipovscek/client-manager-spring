DROP TABLE IF EXISTS client;

CREATE TABLE client(
	  id INT AUTO_INCREMENT  PRIMARY KEY,
      name VARCHAR(250) NOT NULL,
      client_type VARCHAR(4) NOT NULL,
      document VARCHAR(14) NOT NULL
);

insert into client (name, client_type, document) VALUES
('Guilherme Felipe Aragão', 'CPF', '99993191221' ),
('Lara Lara Marlene Aparecida Corte Real', 'CPF', '75095710650'),
('Lucas Enrico Novaes', 'CPF', '24509971133'),
('Lorena e Sérgio Locações de Automóveis ME', 'CNPJ', '48692504000146'),
('Vinicius e Luciana Eletrônica Ltda', 'CNPJ', '03800634000117'),
('Bryan e Lucas Telas Ltda', 'CNPJ', '21292456000142'),
('Isis Isabel Julia Lima','CPF','03230736036'),
('Marcelo Noah Cláudio Teixeira','CPF','39092668869'),
('Betina Raquel Tereza da Silva','CPF','56024875304'),
('Murilo Rafael da Paz','CPF','57929068153'),
('Gabriela Luiza Clarice Costa','CPF','12621429033'),
('Vicente Iago Barbosa','CPF','69632205812'),
('Ian Enzo Marcelo Cavalcanti','CPF','09921994506');
