-------------------------------------------------------------------
|             	  		APS DE APLICATIVOS		          	          |
-------------------------------------------------------------------

Por enquanto, só temos uma parte do codigo feito. A parte de pegar do banco a ultima compra do usuario e realizar uma nova compra.

Para isso, é necessario os seguintes inserts no banco:

insert into reajuste (id, data, valor, obs) values (1, '10/04/2016', 2.50, 'reajustado pelo aumento da inflacao');

insert into tipo (id, nome) values (1, 'aluno');

insert into usuario (ra, senha, nome, tipo, foto) values (1724487, '1234abcd', 'daniel venturini', 1, 'http://www.ticket.ru.utfpr.com/photos/1724487.jpg');

A parte que está pronta é a parte de insert e select generico no Postgres. A conexao tambem está pronta.
A parte da venda para o usuario tambem. Ela funciona assim: É realizado um select no tabela refeicao, onde está todo o historico do usuario. Entao, recuperamos o ultimo registro e o campo que nos interessa é o saldo. Apos algumas operacoes, é realizada um novo insert na tabela, depois de recuperar o reajuste.

Tambem começamos a implementar web a parte da tabela de extrato. Porem está bem no começo.
