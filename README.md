# Blog Pessoal Java 

Este projeto é um Blog Pessoal desenvolvido em Java que oferece um ambiente seguro e flexível para criar, gerenciar e compartilhar postagens online. Ele foi construído com base em um sistema de banco de dados composto por quatro tabelas principais: Tema, Postagem, Usuário e ODT UsuarioLogin.

## Tabelas do Banco de Dados
1. Tema
A tabela Tema armazena os temas ou categorias associados às postagens, permitindo uma organização eficaz das informações.

2. Postagem
A tabela Postagem contém as informações das postagens feitas pelos usuários, incluindo título, conteúdo e data de criação.

3. Usuário
A tabela Usuário é responsável por armazenar os dados dos usuários do sistema, incluindo informações como nome, e-mail e senha.

4. ODT UsuarioLogin
Esta tabela ODT (One-time Data) é usada para armazenar informações temporárias relacionadas ao login de usuários.

## Funcionalidades
O projeto oferece as seguintes funcionalidades:

1. CRUD de Usuários
Você pode executar operações CRUD (Criar, Ler, Atualizar e Deletar) relacionadas aos usuários. Isso inclui criar novos usuários, visualizar informações de usuários existentes, atualizar dados de usuários e excluir contas de usuário.

2. CRUD de Postagens
Você pode criar, ler, atualizar e excluir suas próprias postagens. Isso permite que os usuários gerenciem seu conteúdo de maneira eficiente.

3. Autenticação com Spring Boot Security
O projeto utiliza o Spring Boot Security para fornecer autenticação básica de segurança. Ele incorpora o uso de token JWT (JSON Web Token) para proteger as rotas e garantir que apenas usuários autenticados tenham acesso às funcionalidades protegidas.

4. Documentação Swagger
Ao entrar no sistema, os usuários têm acesso à documentação Swagger, que permite explorar as APIs disponíveis de forma interativa. Isso torna mais fácil entender e usar as funcionalidades oferecidas pelo sistema.

Este projeto é uma excelente escolha para quem deseja criar um blog pessoal em Java, com recursos de autenticação segura e documentação abrangente para as APIs. Sinta-se à vontade para explorar e contribuir para este projeto no GitHub!




