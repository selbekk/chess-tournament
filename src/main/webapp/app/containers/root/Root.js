import React, { PropTypes } from 'react';

import App from '~/containers/app';

const RootContainer = props => (
    <App>
        {props.children}
    </App>
);

RootContainer.propTypes = {
    children: PropTypes.node.isRequired,
};

export default RootContainer;
