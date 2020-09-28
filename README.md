# importXml

Projeto de geração importação de arquivos XML entre Prestadores de Serviço e Operadora de Plano de Saude, independente da versão estabelecida pela ANS.

Neste projeto, os arquivos de XML eram armazenados em uma Classe/Objeto que servia debase para a inserção dita na base de dados (uma classe que abrangia os dados das diferentes versões enviadas por diferentes prestadores.

Este projeto foi criado para atender uma demanda das Operadoras de Plano de Saúde CESAN (Registo ANS nº 39.240-5), tendo seu início no ano de 2013.

Observações:

Foram omitidos os dados das consultas SQL feito na base de dados, por uma questão de segurança e de tratar-se de uma produção específica para cada BD;

A classe "Inicializa" localizada no pacote "br.com.importacao.view.presentation" inicializa o programa;

Todas as ações são feitas pelo usuário através de uma interface específica.
