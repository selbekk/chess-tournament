import React from 'react';
import { Router, Route, IndexRoute } from 'react-router';

import Root from '~/containers/root/Root';
import OverviewPage from '~/containers/overview-page/OverviewPage';

export default (
    <Router>
        <Route path="/" component={Root}>
            <IndexRoute component={OverviewPage} />
        </Route>
    </Router>
);
