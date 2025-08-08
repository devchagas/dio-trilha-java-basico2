# 🧠 Sistema de Validação de Processo Seletivo

Este projeto simula um processo seletivo automatizado, onde candidatos são avaliados com base no salário pretendido e, se forem selecionados, recebem tentativas de ligação para contato.

## 🚀 Funcionalidades

- Geração aleatória do salário pretendido dos candidatos.
- Seleção de candidatos com base no salário base definido.
- Impressão de uma lista com os selecionados.
- Simulação de tentativas de ligação (com até 3 tentativas por candidato).
- Contador e feedback de ligação para cada candidato.

## 🧩 Lógica Utilizada

- Um array com candidatos é percorrido.
- Cada um tem um valor de salário pretendido entre R$1800 e R$2200 (gerado aleatoriamente).
- Candidatos com pretensão menor ou igual ao salário base (R$2000) são selecionados.
- Após a seleção, é feita uma simulação de ligação, com até 3 tentativas por candidato.
