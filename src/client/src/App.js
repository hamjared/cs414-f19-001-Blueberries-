import React, { Component } from 'react';
import request from 'request';
import { Router, Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import Home from './Home';
import {PrivateRoute} from './PrivateRoute';
import { history } from './History';



export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userID: "example",
            wasInitialized: false
        };
        this.updateUser = this.updateUser.bind(this);
    }
    dummyApiCall() {

        request('http://localhost:4567/hello', function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', body);
        });
    }

    updateUser(name) {
        this.setState({userID: name});
    }

    componentDidMount() {
        localStorage.clear();
    }


    render() {
        return (
            <div>
                <Router history={history}>
                    <Switch>
                        <Redirect exact from="/" to="/Login" />
                        <Route path="/Login" render={(props) => <Login {...props} updateUser={this.updateUser} user={this.state.userID} />}/>
                        <Route path="/Register" component={Register}/>
                        <PrivateRoute exact path="/Home" component={Home} wasInitialized={this.state.wasInitialized} user={this.state.userID}/>
                    </Switch>
                </Router>
                <br/>
                <br/>
                <br/>
                <br/>
            </div>

        );
    }
}
