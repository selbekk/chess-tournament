const getConfig = require('hjs-webpack');

const config = getConfig({
    in: 'app/index.js',
    out: '../resources/assets/bundle.js',
    clearBeforeBuild: true,
});

module.exports = config;
