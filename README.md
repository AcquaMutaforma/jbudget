#jbudget

Interfaces:
-ASSET- Ha la responsabilità di definire gli asset a cui vengono associati i movimenti come i portafogli o i conti in banca
-MOVEMENT- Interfaccia che definisce il comportamento dei movimenti
-CATEGORY- Definisce i metodi che serviranno ai tag, associati ai movimenti, conti e transazioni
-TRANSACTION- Questa interfaccia definisce il funzionamento delle transazioni, queste andranno a contenere i movimenti
-LEDGE- Questa interfaccia definisce il ledge, che si occupa delle transazioni, dei tag, degli asset e degli scheduled 
-ScheduledTransactions- Definisce le funzionalità delle transazioni posticipate
-Budget- Descrive il budget previsto per determinati tag 
