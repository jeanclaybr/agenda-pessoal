Notificação enviada por email

Meta:
@integration_test
@mock servidor smtp

Narrativa:
Para obter notificações de meus compromissos em qualquer lugar
Como uma pessoa ocupada
Desejo receber um email informando de meus compromissos

Cenário: Pessoa recebe notificação de um comprimisso

Dado que possuo o seguinte compromisso:
|descricao                 |inicio          |fim             |notificacoes|
|Consulta com nutricionista|10/08/2015 09:30|10/08/2015 11:30|1 hora antes|
Dado que o meu email é drummond@poesia.com.br
Dado que meu nome é Carlos Drummond de Andrade
Quando chegar a hora de enviar as notificações pendentes
Então receberei o seguinte email:
    Assunto: Lembrete!
    Mensagem:
        Oi, Carlos!
        Tudo bem?
        Passei aqui para avisá-lo do seu compromisso "Consulta com nutricionista",
        marcado para o dia 10/08/2015, às 09:30.

        Não vá se atrasar. ;)

        Abraços!

Cenário: Pessoa recebe notificação de vários comprimissos

Dado que possuo os compromissos:
|descricao                 |inicio          |fim             |notificacoes              |
|Consulta com nutricionista|10/08/2015 09:30|10/08/2015 11:30| 1 hora antes             |
|Buteco com os amigos      |10/08/2015 19:30|                |11 horas antes            |
|Manhã de autógrafos       |11/08/2015 08:30|10/08/2015 12:00| 1 dia antes, 1 hora antes|
Dado que o meu email é drummond@poesia.com.br
Dado que meu nome é Carlos Drummond de Andrade
Quando chegar a hora de enviar as notificações pendentes
Então receberei o seguinte email:
    Assunto: Lembrete!
    Mensagem:
        Oi, Carlos!
        Tudo bem?
        Passei aqui para avisá-lo dos seus compromissos:
            * Consulta com nutricionista, marcado para o dia 10/08/2015, às 09:30.
            * Buteco com os amigos, marcado para o dia 10/08/2015, às 19:30.
            * Manhã de autógrafos, marcado para o dia 11/08/2015, às 08:30.

        Não vá se atrasar. ;)

        Abraços!
    