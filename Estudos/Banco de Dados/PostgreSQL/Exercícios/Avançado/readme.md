# 🎯 SQL — Avançado

**Total de exercícios neste nível:** 30

## 📝 Lista de Exercícios

- [01 Query Optimizer](./01%20Query%20Optimizer): Entenda profundamente o Query Optimizer do PostgreSQL: estatísticas, planos, hints.
- [02 Index Types](./02%20Index%20Types): Explore os tipos de índice: B-Tree, Hash, GIN, GiST, SP-GiST, BRIN. Quando usar cada um.
- [03 Index Only Scan](./03%20Index%20Only%20Scan): Configure índices covering para atingir Index-Only Scans e eliminar acesso à tabela.
- [04 Parallel Query](./04%20Parallel%20Query): Habilite e configure Parallel Query no PostgreSQL para queries pesadas.
- [05 Connection Pooling](./05%20Connection%20Pooling): Configure PgBouncer para pooling de conexões e compare os modos transaction/session.
- [06 WAL Replication](./06%20WAL%20Replication): Configure streaming replication com WAL para um standby de leitura.
- [07 Logical Replication](./07%20Logical%20Replication): Configure Logical Replication para replicar tabelas específicas entre bancos.
- [08 Point In Time Recovery](./08%20Point%20In%20Time%20Recovery): Configure PITR usando WAL archives para restaurar o banco a um momento específico.
- [09 Vacuum Autovacuum](./09%20Vacuum%20Autovacuum): Entenda VACUUM, AUTOVACUUM, table bloat e como monitorar e tunar o autovacuum.
- [10 Toast Storage](./10%20Toast%20Storage): Entenda o mecanismo TOAST para armazenamento de dados grandes e seu impacto.
- [11 MVCC Internals](./11%20MVCC%20Internals): Estude o MVCC (Multi-Version Concurrency Control) do PostgreSQL: xmin, xmax, cid.
- [12 Lock Monitoring](./12%20Lock%20Monitoring): Monitore e resolva deadlocks e lock contention com pg_locks e pg_stat_activity.
- [13 Advisory Locks](./13%20Advisory%20Locks): Use Advisory Locks para coordenação de processos sem bloqueio de linhas.
- [14 FDW Foreign Tables](./14%20FDW%20Foreign%20Tables): Configure Foreign Data Wrappers para consultar dados externos (MySQL, MongoDB, S3).
- [15 Pl Pgsql Avançado](./15%20Pl%20Pgsql%20Avançado): Escreva stored procedures complexas com cursores, exception handling e dynamic SQL.
- [16 Pl Python](./16%20Pl%20Python): Use PL/Python para escrever funções no banco que executam código Python.
- [17 Custom Aggregate](./17%20Custom%20Aggregate): Crie uma função de agregação customizada em C ou PL/pgSQL.
- [18 Custom Operator](./18%20Custom%20Operator): Defina um operador customizado para tipos de dados do seu domínio.
- [19 Domain Types](./19%20Domain%20Types): Crie Domain Types para representar tipos de negócio com validação (email, CPF).
- [20 Range Types](./20%20Range%20Types): Use Range Types (int4range, tsrange) para modelar intervalos e verificar sobreposições.
- [21 Sharding Citus](./21%20Sharding%20Citus): Configure sharding horizontal com a extensão Citus para escala de escrita.
- [22 TimescaleDB](./22%20TimescaleDB): Use TimescaleDB para dados de série temporal com compressão e continuous aggregates.
- [23 PostGIS Geoespacial](./23%20PostGIS%20Geoespacial): Configure PostGIS e escreva queries geoespaciais para encontrar pontos dentro de polígonos.
- [24 Pg Stat Statements](./24%20Pg%20Stat%20Statements): Habilite pg_stat_statements para identificar as queries mais custosas em produção.
- [25 Hypothetical Indexes](./25%20Hypothetical%20Indexes): Use a extensão HypoPG para simular índices sem criá-los de fato.
- [26 Data Versioning Temporal](./26%20Data%20Versioning%20Temporal): Implemente versionamento completo de dados usando a extensão temporal_tables ou Hibernate Envers.
- [27 Schema Migration Zero Downtime](./27%20Schema%20Migration%20Zero%20Downtime): Execute migrações de schema sem downtime: expand-contract, backfill e rename.
- [28 Benchmark Pgbench](./28%20Benchmark%20Pgbench): Benchmark o banco de dados com pgbench, analise TPS e identifique gargalos.
- [29 Distributed Transactions](./29%20Distributed%20Transactions): Implemente distributed transactions entre dois bancos PostgreSQL usando 2PC (Two-Phase Commit).
- [30 Database Design Principles](./30%20Database%20Design%20Principles): Documente as melhores práticas de design de banco de dados: normalização, desnormalização estratégica e modelagem de domínio.
