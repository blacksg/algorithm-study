package hash;

import java.util.*;

/**
 * @문제 <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42579">베스트앨범</a>
 * @사이트 프로그래머스
 * @난이도 Lv.3
 * @알고리즘 해시
 */
class PG42579 {

    public int[] solution(String[] genreNames, int[] playCounts) {
        Map<String, Genre> genreMap = new HashMap<>();
        for (int songId = 0; songId < genreNames.length; songId++) {
            String genreName = genreNames[songId];
            if (!genreMap.containsKey(genreName)) {
                genreMap.put(genreName, new Genre());
            }
            Song song = new Song(songId, playCounts[songId]);
            genreMap.get(genreName).addSong(song);
        }
        List<Genre> sortedGenres = new ArrayList<>(genreMap.values());
        Collections.sort(sortedGenres);
        List<Integer> trackList = new ArrayList<>();
        for (Genre genre : sortedGenres) {
            List<Song> songs = genre.getSongs();
            Collections.sort(songs);
            int size = Math.min(songs.size(), 2);
            for (int i = 0; i < size; i++) {
                trackList.add(songs.get(i).getId());
            }
        }
        int[] tracks = new int[trackList.size()];
        for (int i = 0; i < tracks.length; i++) {
            tracks[i] = trackList.get(i);
        }
        return tracks;
    }

    static final class Genre implements Comparable<Genre> {

        private final List<Song> songs;

        private int totalPlayCount;

        public Genre() {
            this.songs = new ArrayList<>();
            this.totalPlayCount = 0;
        }

        public List<Song> getSongs() {
            return songs;
        }

        public int getTotalPlayCount() {
            return totalPlayCount;
        }

        public void addSong(Song song) {
            songs.add(song);
            totalPlayCount += song.getPlayCount();
        }

        @Override
        public int compareTo(Genre other) {
            return other.getTotalPlayCount() - totalPlayCount;
        }
    }

    static final class Song implements Comparable<Song> {

        private final int id;

        private final int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        public int getId() {
            return id;
        }

        public int getPlayCount() {
            return playCount;
        }

        @Override
        public int compareTo(Song another) {
            int playCountDifference = another.getPlayCount() - playCount;
            return (playCountDifference == 0) ? (id - another.getId()) : playCountDifference;
        }
    }
}
