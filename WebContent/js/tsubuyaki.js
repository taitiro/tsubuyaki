var count = 0;
// 更新処理
function backPage() {
    console.log('test');
    history.back();
};
function reloadPage() {
    confirm('更新します');
    location.reload(true);
};
function confirmSubmit(str) {
    if (confirm(str)) {
        return true;
    } else {
        return false;
    }
};
// フォームチェック
function validateForm() {
    'use strict';
    var i = 0, // イテレータ
    inputStr = document.getElementsByTagName('input');// inputタグ要素のリスト
    // 全てのinputタグの中身についてチェック（type=submitも．逆に言うとselectとかoptionとかはチェックしてない）
    for (i = 0; i < inputStr.length; i++) {
        // 日付チェック
        if ((inputStr[i].getAttribute('type') == 'date')
                && !inputStr[i].value.match(/^\d{4}-\d{2}-\d{2}$/)) {
            alert('日付は0000-00-00の形式で入力してください: ' + inputStr[i].value);
            return false;
        } else if ((inputStr[i].getAttribute('type') == 'number')) {// typeがnumber型の場合，数値に当てはまるか検証
            if ((inputStr[i].className.indexOf('int') != -1)
                    && !inputStr[i].value.match(/^-{0,1}\d+$/)) {// classにintがある場合，整数に当てはまるか検証
                alert('整数は半角数字と行頭のマイナスで入力してください: ' + inputStr[i].value);
                return false;
            } else if (!inputStr[i].value.match(/^-{0,1}\d+(\.{0,1}\d+){0,1}$/)) {// 数値に当てはまるか検証
                alert('数値は半角数字と行頭のマイナスと小数点のみで入力してください: ' + inputStr[i].value);
                return false;
            }
        }
        if ((inputStr[i].className.indexOf('alphabet') != -1) && !inputStr[i].value.match(/^[a-zA-Z0-9]+$/)) {
            alert('パスワードとユーザー名は半角英数で入力してください');
            console.log("error:" + inputStr[i].value);
            return false;
        }else{
            console.log("大丈夫でした" + i );
            console.log(inputStr[i].className.indexOf('alphabet') + ":" + inputStr[i].value);
            
        }
        if (inputStr[i].value.match(/<("[^"]*"|'[^']*'|[^'">])*>/)) {
            alert('HTMLタグを入力しちゃやーよ ');
            return false;
        }
    }
    // 変換作業
    for (i = 0; i < inputStr.length; i++) {
        if (inputStr[i].className.indexOf('cookie') != -1) {
            inputStr[i].value = encodeURI(inputStr[i].value);
        }
        if (inputStr[i].className.indexOf('rawPassword') != -1) {
            inputStr[i].value = CybozuLabs.MD5.calc(inputStr[i].value);
        }
        // 送信ボタンを使用不可に
        if ((inputStr[i].getAttribute('type') == 'submit')) {
            inputStr[i].disabled = true;
        }
    }
    // 二度押し禁止
    if (count == 0) {
        count = 1;
    } else {
        alert('串かつはソースの二度漬け禁止．それと同じように（！？）送信ボタンは二度押し禁止！');
        return false;
    }
    
    return true;
};

function init() {
    'use strict';
    var i = 0, // イテレータ
    form = document.getElementsByTagName('form');// form要素の配列
    // 更新処理
    if (document.getElementById('reload')) {
        document.getElementById('reload').onclick = reloadPage;
    }
    // 戻る処理
    if (document.getElementById('back')) {
        document.getElementById('back').onclick = backPage;
    }
    if (document.getElementById('confirmDeleteTsubuyaki')) {
        document.getElementById('confirmDeleteTsubuyaki').onclick = function() {
            return confirmSubmit("全てのつぶやきが削除されます．本当に実行しますか？");
        };
    }
    // フォームチェック
    for (i = 0; i < form.length; i++) {
        form[i].onsubmit = validateForm;
    }
    
};

window.onload = init;