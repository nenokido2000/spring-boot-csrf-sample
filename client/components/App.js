import React from 'react';
import request from 'superagent';
import cookie from 'cookie';

export default class App extends React.Component {

    constructor(props) {
        super(props);
    }

    handleGet() {
        request
            .get('/api')
            .end((err, res) => {
                if (res.ok) {
                    alert(res.body.message);
                } else if (res.forbidden) {
                    alert('forbidden');
                } else {
                    alert(`error:${res.status}`);
                }
            });
    }

    handlePut() {
        const cookies = cookie.parse(document.cookie);
        const csrf = cookies._ctkn;
        if (csrf) {
            request
                .put('/api')
                .set('X-CSRF-TOKEN', csrf)
                .end((err, res) => {
                    if (res.ok) {
                        alert(res.body.message);
                    } else if (res.forbidden) {
                        alert('forbidden');
                    } else {
                        alert(`error:${res.status}`);
                    }
                });
        } else {
            alert('エラー：不正な遷移を検知したため処理を続行できません');
        }
    }

    render() {
        return (
            <div>
                <h2>Spring Boot CSRF Sample</h2>
                <button type="button" onClick={this.handleGet.bind(this)} >GET</button>
                <button type="button" onClick={this.handlePut.bind(this)} >PUT</button>
            </div>
        );
    }
}