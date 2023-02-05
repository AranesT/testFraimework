REM БАТ-скрипт, позволяющий производить репликацию из локального репозитория в любой другой. Например, находящийся в другой системе контроля версий
REM Например, github -> gitlab, bitbucket -> Gitea

REM Заменить на свой локальный путь к проекту
cd C:/Users/you/IdeaProjects/testFraimework
git init
REM синтаксис git remote add ВАШЕ_НАЗВАНИЕ_УДАЛЕННОГО_РЕПОЗИТОРИЯ_ДЛЯ_ЛОКАЛЬНОГО_ИПОЛЬЗОВАНИЯ ССЫЛКА_НА_УДАЛЕННЫЙ_РЕПОЗИТОРИЙ
git remote add gitlab_testFreim git@myGitUrl.ru:testFraimework

:loop
REM название ветки
git checkout master
git pull origin master
REM gitlab_testFreim - ВАШЕ_НАЗВАНИЕ_УДАЛЕННОГО_РЕПОЗИТОРИЯ_ДЛЯ_ЛОКАЛЬНОГО_ИПОЛЬЗОВАНИЯ
git push --force --progress gitlab_testFreim HEAD:master
REM В случае, если нужно пушить несколько веток, повторить шаги, идущие после :loop до текущего (изменив название ветки, конечно же)

REM Время повторения, секунды
timeout /t 1200
goto loop