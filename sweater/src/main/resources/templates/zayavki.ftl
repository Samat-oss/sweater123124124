<#import "parts/common.ftl" as c>

<@c.page>
    <table class="table table-condensed">
    <thead>
    <tr>

        <th>Отделение</th>
        <th>Проблема</th>
        <th>Номер</th>
        <th>Время подачи</th>
    </tr>
    </thead>
    <#list messages as message>

            <div class="m-2">
                <tbody>
                <tr>
                    <td>${message.otdel}</td>
                    <td>${message.problema}</td>
                    <td>${message.number}</td>
                    <td>${message.vremya}</td>
                </tr>
                </tbody>
                <#else>
                    No message
        </#list>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Подать заявку
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">


            <form method="post" action="/zayavki" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="otdel" placeholder="Отделение" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="problema" placeholder="Опишите вашу проблему">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="number" placeholder="Введите номер телефона" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="vremya" placeholder="Введите время подачи заявки" />
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Выбрать файл</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </div>
            </form>
        </div>
    </div>



    </div>
</@c.page>