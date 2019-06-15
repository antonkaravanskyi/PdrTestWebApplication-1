<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ім'я :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Введіть ім'я" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль :</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Введіть пароль" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <#if !isRegisterForm><a href="/registration"></a></#if>
        <button class="btn btn-dark" type="submit"><#if isRegisterForm>Реєстрація<#else>Авторизація</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-dark" type="submit">Вийти</button>
    </form>
</#macro>