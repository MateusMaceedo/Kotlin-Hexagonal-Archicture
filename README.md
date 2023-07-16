**Estrutura Hexagonal em Kotlin - Documentação**

<p align="center">
  <a href="https://github.com/hexagonkt/hexagon/actions">
    <img
      alt="GitHub Actions"
      src="https://github.com/hexagonkt/hexagon/workflows/Release/badge.svg" />
  </a>
  <a href="https://hexagonkt.com/jacoco">
    <img src="https://hexagonkt.com/img/coverage.svg" alt="Coverage" />
  </a>
  <a href="https://search.maven.org/search?q=g:com.hexagonkt">
    <img src="https://hexagonkt.com/img/download.svg" alt="Maven Central Repository" />
  </a>
</p>

#### Introdução
A estrutura hexagonal, também conhecida como arquitetura de ports and adapters, é um padrão arquitetural que visa separar as regras de negócio do sistema de suas dependências externas, como frameworks, bancos de dados e serviços externos. Essa separação facilita o desenvolvimento, o teste e a manutenção do sistema, além de permitir a substituição de componentes externos sem afetar a lógica de negócio.

Este documento apresenta uma descrição e um exemplo prático da estrutura hexagonal em Kotlin, abordando seus principais componentes e princípios.

#### Componentes Principais
A estrutura hexagonal consiste em três componentes principais:

1. **Domínio (Core)**: Representa o coração da aplicação, contendo as regras de negócio e a lógica essencial do sistema. O domínio é independente das implementações externas e não conhece detalhes de frameworks, banco de dados ou serviços externos.

2. **Adaptadores**: São responsáveis por conectar o domínio às implementações externas. Existem dois tipos de adaptadores:

   - **Adaptadores de Entrada (Inbound Adapters)**: São responsáveis por receber as requisições externas e convertê-las em objetos compreensíveis pelo domínio. Podem ser interfaces de API REST, controllers, CLI (Command-Line Interface), entre outros.

   - **Adaptadores de Saída (Outbound Adapters)**: São responsáveis por implementar a comunicação do sistema com elementos externos, como bancos de dados, serviços de terceiros, frameworks, etc. Podem ser interfaces de acesso a banco de dados, serviços REST, clientes de serviços, entre outros.

3. **Configuração**: Realiza a injeção de dependências e configuração dos componentes, permitindo a comunicação entre o domínio e os adaptadores. É nessa camada que ocorre a interconexão dos componentes.

#### Exemplo Prático
A seguir, apresentaremos um exemplo prático de uma estrutura hexagonal em Kotlin.

Considere um sistema de gerenciamento de produtos, onde temos as seguintes funcionalidades:

- Cadastro de produtos.
- Consulta de produtos por ID.
- Atualização de produtos.

A estrutura hexagonal desse exemplo seria organizada da seguinte forma:

1. **Domínio (Core)**:
   - `Product.kt`: Representa a entidade do produto com seus atributos e métodos de validação.

   - `ProductService.kt`: Define a interface do serviço de produtos contendo os métodos de criação, consulta e atualização de produtos.

2. **Adaptadores**:
   - **Adaptadores de Entrada (Inbound Adapters)**:
     - `ProductController.kt`: Implementa um controlador REST que recebe as requisições HTTP, converte os dados para objetos do domínio e invoca os métodos do serviço de produtos.

   - **Adaptadores de Saída (Outbound Adapters)**:
     - `ProductRepository.kt`: Define a interface de acesso ao banco de dados para as operações CRUD de produtos.

     - `ProductRepositoryImpl.kt`: Implementa a interface `ProductRepository` utilizando um banco de dados específico.

3. **Configuração**:
   - `Application.kt`: Realiza a configuração e a inje

ção de dependências dos componentes. Cria as instâncias dos adaptadores e realiza a injeção do repositório e do serviço de produtos.

#### Considerações Finais
A estrutura hexagonal em Kotlin é uma abordagem arquitetural poderosa para criar sistemas flexíveis, testáveis e de fácil manutenção. A separação clara entre o domínio e os adaptadores permite uma evolução independente dos componentes e facilita a substituição de tecnologias externas.

Ao implementar a estrutura hexagonal, é importante seguir os princípios SOLID, como a inversão de dependência (Dependency Inversion Principle - DIP), para garantir a alta coesão e o baixo acoplamento entre os componentes.

Lembre-se de adaptar a estrutura hexagonal de acordo com as necessidades e requisitos específicos do seu projeto, ajustando os componentes e os nomes dos arquivos conforme apropriado.

Com a estrutura hexagonal, você estará preparado para desenvolver sistemas robustos, flexíveis e escaláveis em Kotlin.

---------------------------------------------------------
#### Setup no linux
1. Abra um terminal no Linux.

2. Edite o arquivo .profile ou .bashrc no seu diretório pessoal usando um editor de texto, como o nano:
```bash
nano ~/.profile
```
ou
```bash
nano ~/.bashrc
```

3. No final do arquivo, adicione a seguinte linha:
```bash
export PATH="$PATH:/caminho/para/kotlinc/bin"
```
Substitua /caminho/para pelo caminho absoluto para o diretório kotlinc/bin onde o compilador Kotlin está localizado.

4. Pressione Ctrl + O para salvar as alterações no arquivo.
5. Pressione Ctrl + X para sair do editor de texto.
6. No terminal, execute o seguinte comando para carregar as alterações no arquivo:
```bash
source ~/.profile
```
ou
```bash
source ~/.bashrc
```
Após essas etapas, o diretório kotlinc/bin será adicionado ao seu PATH e você poderá executar o comando kotlinc de qualquer diretório no terminal.

Lembre-se de substituir "/caminho/para" pelo caminho correto para o diretório kotlinc/bin no seu ambiente. Verifique também se o executável kotlinc está presente no diretório especificado.

---------------------------------------------------------

#### Setup localstack

Para subir os serviços do localstack, digitar o seguinte comando:
```bash
docker-compose -f local-stack-docker-compose.yml up -d
```

DynamoDB:
```json
{
  "ccb_controle_envio": {
    "dados_formalizacao": {
      "numero_proposta_credito_consignado_correspondente": "1234564",
      "status_formalizacao": "formalizacao",
      "data_hora": "2023-10-01T00:00:00"
    },
    "notificacao": {
      "data_hora": "2023-10-01T00:00:00",
      "status_envio": "sucesso"
    },
    "dados_cliente": {
      "codigo_identificacao_inquilino": "123124564",
      "codigo_identificacao_pessoa": "856446544645"
    }
  }
}

```

---------------------------------------------------------

#### Setup Prometheus e Grafana

Para executar o Prometheus e o Grafana, digite o seguinte comando no terminal, no diretorio Kotlin-Hexagonal-Archicture/app/docker/docker-compose.yaml

```bash
docker-compose up
```

Para acessar a rota de metricas do Prometheus, acessar a seguinte URL:

```url
http://localhost:{portadaaplicacao}/actuator/prometheus
```

Para acessar o dash do Prometheus, acessar a seguinte URL:
```url
http://localhost:{portadaaplicacao}/
```

Para acessar o dash do Grafana, acessar a seguinte URL:
```url
http://localhost:3000
```
