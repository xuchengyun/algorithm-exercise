class Twitter {

    /** Initialize your data structure here. */
    Map<Integer, Set<Integer>> followers;
    Map<Integer, LinkedList<Tweet>> tweets;
    int timestamp = 0;
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).add(tweet);
        if (!followers.containsKey(userId)) {
            followers.put(userId, new HashSet<>());
        }
        followers.get(userId).add(userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        Set<Integer> followeeSet = new HashSet<>();
        LinkedList<Tweet> ftweets = new LinkedList<Tweet>();
        if (followers.containsKey(userId)) {
            followeeSet = followers.get(userId);
            for (Integer followee: followeeSet) {
                if (tweets.containsKey(followee)) {
                    ftweets = tweets.get(followee);
                    for (Tweet tweet: ftweets) {
                        pq.add(tweet);
                    }
                }
            }         
        }
        while (res.size() < 10 && !pq.isEmpty()) {
            res.add(pq.poll().tweetId);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId) && followeeId != followerId) {
            followers.get(followerId).remove(followeeId);
        }
    }
    
    class Tweet{
        int time;
	    int tweetId;
	    public Tweet(int tweetId) {
		    this.tweetId = tweetId;
		    this.time = timestamp++;
	    }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */