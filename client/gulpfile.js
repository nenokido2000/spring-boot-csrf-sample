var gulp = require('gulp');
var babelify = require('babelify');
var del = require('del');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var uglify = require('gulp-uglify');
var buffer = require('vinyl-buffer');

var DEST_DIRECTORY = '../static/js/dist';

gulp.task('clean', function (cb) {
    del([DEST_DIRECTORY]);
    cb();
});

gulp.task('build', ['clean'], function () {
    browserify(['./index.js'], {debug: true})
        .transform(babelify)
        .bundle()
        .on('error', function (err) {
            console.log(err.message);
        })
        .pipe(source('bundle.js'))
        .pipe(buffer())
        .pipe(uglify())
        .pipe(gulp.dest(DEST_DIRECTORY));
});

gulp.task('watch', function () {
    gulp.watch('./index.html', ['build']);
    gulp.watch('./index.js', ['build']);
    gulp.watch('./components/**/*.js', ['build']);
});
