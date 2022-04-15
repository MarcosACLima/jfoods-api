insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1, 'Subway', 10.5, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Giraffas', 7.49, 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Thai Deliver', 10, 2);

insert into estado (id, nome) values (1, 'Goias');
insert into estado (id, nome) values (2, 'Minas Gerais');

insert into cidade (id, nome, estado_id) values (1, 'Anapolis', 1);
insert into cidade (id, nome, estado_id) values (2, 'Uberlandia', 2);
insert into cidade (id, nome, estado_id) values (3, 'Rio Verde', 1);
insert into cidade (id, nome, estado_id) values (4, 'Goiania', 1);
insert into cidade (id, nome, estado_id) values (5, 'Belo Horizonte', 2);

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'ADICIONAR_COZINHAS', 'Permite inserir cozinhas');

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Boleto');